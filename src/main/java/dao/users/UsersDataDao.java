package dao.users;

import entity.products.ProductEntity;
import entity.users.UsersEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by grigacs on 4/7/2016.
 */
@Named(value = "userDao")
@RequestScoped
public class UsersDataDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProductEntity> list() {
        TypedQuery<ProductEntity> query = entityManager.createQuery("select u from ProductEntity u", ProductEntity.class);
        return query.getResultList();
    }
}