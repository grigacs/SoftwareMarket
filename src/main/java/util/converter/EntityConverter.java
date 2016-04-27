package util.converter;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

@Named
public class EntityConverter implements Converter {

	@PersistenceContext
	private EntityManager entityManager;

//	@Inject
//	private Logger logger;

	public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
		try {
			String[] split = string.split(":");
			Class<?> clazz = Class.forName(split[0]);
			for (Field f : clazz.getDeclaredFields()) {
				if (f.isAnnotationPresent(Id.class)) {
					Method valueOfMethod = f.getType().getMethod("valueOf", String.class);
					return entityManager.find(clazz, valueOfMethod.invoke(null, split[1]));
				}
			}
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			//logger.severe("Cannot convert entity.");
		}
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
		if (null != object) {
			try {
				Class<?> clazz = object.getClass();
				for (Field f : clazz.getDeclaredFields()) {
					if (f.isAnnotationPresent(Id.class)) {
						f.setAccessible(true);
						return clazz.getCanonicalName() + ":" + f.get(object);
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				//logger.severe("Cannot convert entity.");
			}
		}
		return null;
	}

}
