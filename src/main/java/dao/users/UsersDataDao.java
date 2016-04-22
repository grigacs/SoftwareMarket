package dao.users;


import entity.users.UsersEntity;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dao.base.GenericDAO;


/**
 * Created by krisinho4.
 */

public class UsersDataDao extends GenericDAO<UsersEntity, Long> {

	private static final long serialVersionUID = 1L;

	public UsersDataDao() {
		super(UsersEntity.class);
	}

	public UsersEntity getByName(String username) {

		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();

		CriteriaQuery<UsersEntity> cq = criteriaBuilder.createQuery(UsersEntity.class);
		Root<UsersEntity> pet = cq.from(UsersEntity.class);
		cq.where(criteriaBuilder.equal(pet.get(UsersEntity.A.USERNAME), username));

		TypedQuery<UsersEntity> query = getEntityManager().createQuery(cq);
		return query.getResultList().get(0);

	}

}