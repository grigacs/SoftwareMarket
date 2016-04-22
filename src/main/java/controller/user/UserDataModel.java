package controller.user;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.core.AbstractDataModel;
import dao.base.GenericDAO;
import dao.users.UsersDataDao;
import entity.users.UsersEntity;

	@Named
	@ViewScoped
	public class UserDataModel extends AbstractDataModel<UsersEntity, Long> {

		private static final long serialVersionUID = -7210487598216166015L;

		@Inject
		private UsersDataDao userDAO;

		public List<UsersEntity> list() {
			return userDAO.list();
		}

		@Override
		protected GenericDAO<UsersEntity, Long> getEntityDao() {
			return userDAO;
		}

	
}
