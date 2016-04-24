package ui;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import controller.user.UserDataModel;
import entity.users.UsersEntity;

@FacesConverter(value = "userConverter")
public class UserConverter implements Converter{
	
	@Inject
	private UserDataModel dataModel;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if("-1".equals(value)){
			return null;
		}
		for(UsersEntity item : dataModel.list()){
			if(String.valueOf(item.getIdUser()).equals(value)){
				return item;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return "-1";
		}
		return String.valueOf(((UsersEntity) value).getIdUser());
	}

	public UserDataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(UserDataModel dataModel) {
		this.dataModel = dataModel;
	}
	
}
