package dao.about;

import entity.products.ProductEntity;
import entity.users.UsersEntity;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by grigacs on 4/20/2016.
 */
@ViewScoped
@Named("about")
public class About implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public int size() {
        TypedQuery<ProductEntity> allproduct = entityManager.createQuery("select u from ProductEntity u", ProductEntity.class);
        return allproduct.getResultList().size();
    }

    public int sizeMember() {
        TypedQuery<UsersEntity> users = entityManager.createQuery("select u from UsersEntity u", UsersEntity.class);
        return users.getResultList().size();
    }

}
