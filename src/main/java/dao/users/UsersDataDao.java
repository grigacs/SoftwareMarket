package dao.users;


import dao.base.GenericDAO;
import entity.users.UsersEntity;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


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
        if(query.getResultList().isEmpty()){

            return null;
        }
        return query.getResultList().get(0);

    }

}