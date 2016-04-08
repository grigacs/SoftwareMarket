package dao.users;

import entity.users.UsersEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by grigacs on 4/7/2016.
 */
@Named
@RequestScoped
public class UsersDataDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    public List<UsersEntity> users() {
        return entityManager.createQuery("SELECT u FROM UsersEntity u", UsersEntity.class).getResultList();
    }
}