package dao.products;


import entity.products.ProductEntity;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Named(value = "productList")
@RequestScoped
public class ProductsListDao implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(popularProducts.class.getSimpleName());

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    private ProductEntity currentProduct;

    public List<ProductEntity> list() {
        TypedQuery<ProductEntity> allproduct = entityManager.createQuery("select u from ProductEntity u", ProductEntity.class);
        return allproduct.getResultList();
    }


    public ProductEntity getCurrentProduct(){
        return currentProduct;
    }

    public void setCurrentProduct(int id) {
        currentProduct = entityManager.find(ProductEntity.class,id);
    }


    public List<ProductEntity> listServers(){
        TypedQuery<ProductEntity> query = entityManager.createQuery("select p from ProductEntity p, ProductCategoryEntity e where p.productId=e.productId and e.categoryName=:name",ProductEntity.class);
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

    public List<ProductEntity> checkedProduct(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String productN = paramMap.get("namePR");
        Query query = entityManager.createQuery("select p from ProductEntity p, ProductCategoryEntity e where p.productName= :name");
        query.setParameter("name", productN);
        LOGGER.info(String.valueOf(query.getResultList()));
        return (List<ProductEntity>) query.setMaxResults(1).getResultList();
    }

}