package controller.core;


import java.io.Serializable;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;

import dao.base.GenericDAO;

public abstract class AbstractEntityAction<EntityType, IdentifierType extends Serializable> implements Serializable {

	private static final long serialVersionUID = -1990165498495936667L;
	
//	@Inject
//	private Logger logger;

	private IdentifierType id;
	
	private EntityType entity;
	
	private Class<EntityType> entityClass;
	
	/**
	 * This constructor is needed because CDI needs no-args constructor in abstract superclasses of CDI beans, 
	 * even if this constructor is not used by child classes.
	 */
	public AbstractEntityAction() {
		// Nothing to do here.
	}
	
	public AbstractEntityAction(Class<EntityType> entityClass) {
		this.entityClass = entityClass;
	}
	
	public void load() {
		if (null == id) {
			try {
				entity = entityClass.newInstance();
				afterCreation();
			} catch (InstantiationException | IllegalAccessException e) {
			//	logger.severe("Cannot instantiate entity.");
			}
		} else {
			entity = getEntityDao().findEntity(id);
			afterFinding();
		}
	}
	
	protected void afterCreation() {
		// Nothing to do here by default.
	}
	
	protected void afterFinding() {
		// Nothing to do here by default.
	}
	
	@Transactional
	public String persist() {
		if (null == id) {
			getEntityDao().persist(entity);
		} else {
			// Entity instance is detached here in case of editing, so merge() should be used instead of persist().
			getEntityDao().merge(entity);
		}
		afterPersisting();
		return getNavigationTargetAfterPersist();
	}
	
	protected void afterPersisting() {
		// Nothing to do here by default.
	}
	
	protected void beforeRemoving(EntityType entityToDelete) {
		// Nothing to do here by default.
	}
	
	@Transactional
	public void remove(IdentifierType identifier) {
		EntityType entityToRemove = getEntityDao().findEntity(identifier);
		beforeRemoving(entityToRemove);
		getEntityDao().remove(entityToRemove);
	}
	
	protected abstract GenericDAO<EntityType, IdentifierType> getEntityDao();
	
	protected abstract String getNavigationTargetAfterPersist();
	
	public IdentifierType getId() {
		return id;
	}
	
	public void setId(IdentifierType id) {
		this.id = id;
	}
	
	public EntityType getEntity() {
		return entity;
	}
	
	public void setEntity(EntityType entity) {
		this.entity = entity;
	}


}
