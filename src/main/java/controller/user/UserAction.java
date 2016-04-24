package controller.user;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.core.AbstractEntityAction;
import dao.base.GenericDAO;
import dao.users.UsersDataDao;
import entity.users.UsersEntity;

@Named
@ViewScoped
public class UserAction extends AbstractEntityAction<UsersEntity, Long>{


	private static final long serialVersionUID = 7834386985312465937L;

	@Inject
	private UsersDataDao userDAO;
	
	public UserAction() {
		super(UsersEntity.class);
	}

	@Override
	protected GenericDAO<UsersEntity, Long> getEntityDao() {
		
		return userDAO;
	}

	@Override
	protected String getNavigationTargetAfterPersist() {
		//TODO navigáció
		return null;
	}
}
