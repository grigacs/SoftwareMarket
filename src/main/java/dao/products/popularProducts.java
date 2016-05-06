package dao.products;

import dao.cart.Item;
import entity.products.ProductEntity;
import entity.orders.FamousProductsEntity;
import entity.users.UsersEntity;
import entity.orders.OrderProductEntity;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Created by grigacs on 4/20/2016.
 */
@ViewScoped
@Named("popular")
public class popularProducts implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(popularProducts.class.getSimpleName());
    private List<ProductEntity> product = new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;


    public List<ProductEntity> famousProducts() {
        Query popularProducts = entityManager.createQuery("select u.productName, count(f.productId) from ProductEntity u , FamousProductsEntity f where u.productId=f.productId group by f.productId order by count(f.productId ) desc");



        return popularProducts.getResultList();
    }


    public List<ProductEntity> product() {
        String[] descriptionPart;
        String beforeFirstDot;
        int i =1;
        List<Object[]> results = entityManager.createQuery("select DISTINCT(u.productName), u.productPrice, u.productPicture, u.productDescription, " +
                "u.productVersion, u.productId, f.saledCount, count(f.productId) " +
                "from ProductEntity u , " +
                "FamousProductsEntity f, " +
                "OrderProductEntity o, " +
                "UsersEntity m " +
                "where u.productId=f.productId and f.orderId = o.orderId and o.idUser = 1 " +
                "group by f.saledCount, f.productId " +
                "order by count(f.productId ), f.saledCount desc").setMaxResults(4).getResultList();

        for (Object[] result : results) {
            String name = (String) result[0];
            double price = ((Number) result[1]).intValue();
            String picture = (String) result[2];
            String description = (String) result[3];
            String version = (String) result[4];
            int saledCount =  ((Number) result[6]).intValue();
            int count = ((Number) result[7]).intValue();
            int id = ((Number) result[5]).intValue();
            descriptionPart= description.split("\\.");
            beforeFirstDot = descriptionPart[0];
            beforeFirstDot =beforeFirstDot+".";
            LOGGER.info(saledCount+ " " + name + ' ' + price + " " + picture + " " +beforeFirstDot + " " + " " + count);
            for(ProductEntity p : product) {
                if(!p.getProductName().equals(name))
                product.add(new ProductEntity(name, picture, price, beforeFirstDot, version, id));
            }
        }

        return  product;


    }

    public List<ProductEntity> productAll() {
        String[] descriptionPart;
        String beforeFirstDot;
        List<Object[]> results = entityManager.createQuery("select u.productName, u.productPrice, u.productPicture, u.productDescription, " +
                "u.productVersion, u.productId, f.saledCount, count(f.productId) " +
                "from ProductEntity u , " +
                "FamousProductsEntity f " +
                "where u.productId=f.productId " +
                "group by f.saledCount, f.productId " +
                "order by count(f.productId ) desc").setMaxResults(4).getResultList();

        for (Object[] result : results) {
            String name = (String) result[0];
            double price = ((Number) result[1]).intValue();
            String picture = (String) result[2];
            String description = (String) result[3];
            String version = (String) result[4];
            int saledCount = ((Number) result[6]).intValue();
            float count = ((Number) result[7]).intValue() + saledCount;
            int id = ((Number) result[5]).intValue();
            descriptionPart= description.split("\\.");
            beforeFirstDot = descriptionPart[0];
            beforeFirstDot =beforeFirstDot+".";
            product.add(new ProductEntity(name, picture, price, beforeFirstDot, version, id));
        }

        return  product;

    }



    public List<FamousProductsEntity> countProducts() {
        Query popularProducts = entityManager.createQuery("select count(f.productId) as id from ProductEntity u , FamousProductsEntity f where u.productId=f.productId group by id order by f.productId desc");
        return popularProducts.getResultList();
    }
}
