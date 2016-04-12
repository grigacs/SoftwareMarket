package dao.products;

import entity.products.ProductCategoryEntity;
import entity.products.ProductEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by grigacs on 4/7/2016.
 */
@Named(value = "productList")
@RequestScoped
public class ProductListDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

   public List<ProductEntity> list() {
        TypedQuery<ProductEntity> query = entityManager.createQuery("select u from ProductEntity u", ProductEntity.class);
        return query.getResultList();
    }

    public List<ProductEntity> listServers(){
        Query query = entityManager.createQuery("select p from ProductEntity p, ProductCategoryEntity e where p.productId=e.productId and e.categoryName=:name");
        query.setParameter("name","Servers");
        return query.getResultList();
    }

    public List<ProductEntity> listDeveloperTools(){
        Query query = entityManager.createQuery("select p from ProductEntity p, ProductCategoryEntity e where p.productId=e.productId and e.categoryName=:name");
        query.setParameter("name","Developer Tools");
        return query.getResultList();
    }

    public List<ProductEntity> listOperatingSystem(){
        Query query = entityManager.createQuery("select p from ProductEntity p, ProductCategoryEntity e where p.productId=e.productId and e.categoryName=:name");
        query.setParameter("name","Operating Systems");
        return query.getResultList();
    }

    public List<ProductEntity> listApplications(){
        Query query = entityManager.createQuery("select p from ProductEntity p, ProductCategoryEntity e where p.productId=e.productId and e.categoryName=:name");
        query.setParameter("name","Applications");
        return query.getResultList();
    }

}