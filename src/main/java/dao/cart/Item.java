package dao.cart;

import entity.products.ProductEntity;

import java.io.Serializable;

/**
 * Created by grigacs on 4/16/2016.
 */

public class Item implements Serializable {
    private ProductEntity p;
    private int quantity;
    private static int allquantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getP() {
        return p;
    }

    public void setP(ProductEntity p) {
        this.p = p;
    }

    public int getAllquantity() {
        return allquantity;
    }

    public void setAllquantity(int allquantity) {
        Item.allquantity = allquantity;
    }
}
