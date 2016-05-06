package dao.cart;

import entity.orders.FamousProductsEntity;
import entity.orders.OrderProductEntity;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Created by grigacs on 4/19/2016.
 */
@ViewScoped
@Named("add")
public class cartToBase implements Serializable {

    @Inject
    ShoppingCart Mycart;

    @Inject
    Item myItem;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persist(final OrderProductEntity entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public void persist(final FamousProductsEntity entity) {
        entityManager.persist(entity);
    }

    public void remove(final OrderProductEntity entity) {
        entityManager.remove(entity);
    }

    public void refresh(final OrderProductEntity entity) {
        entityManager.refresh(entity);
    }

    @Transactional
    public void addtoBase() {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        for (Item item : Mycart.getCart()) {
            OrderProductEntity orderProductEntity = new OrderProductEntity(1,sqlDate, item.getP().getProductPrice(), item.getP().getProductName(), "ordered");
            persist(orderProductEntity);
            FamousProductsEntity famousProductsEntity = new FamousProductsEntity(item.getQuantity(),item.getP().getProductId(),orderProductEntity.getOrderId());
            persist(famousProductsEntity);
        }

        Mycart.getCart().clear();

        myItem.setQuantity(0);
        myItem.setAllquantity(0);

        return;
    }
}
