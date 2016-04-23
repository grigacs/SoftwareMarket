package dao.cart;

import entity.products.ProductEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by grigacs on 4/15/2016.
 */

@Named("cart")
@SessionScoped
public class ShoppingCart implements Serializable {

    private List<Item> cart = new ArrayList<>();
    private float total;
    private int cartSize;
    private static final Logger LOGGER = Logger.getLogger(ShoppingCart.class.getSimpleName());
    private int thisQuantity;

    public ShoppingCart() {

    }

    public int getCartCount() {
        cartSize = 0;
        for (Item item : cart) {
            cartSize = item.getAllquantity();
        }
        return cartSize;
    }


    public float getTotal() {
        total = 0;
        for (Item item : cart) {
            total = (float) (total + (item.getQuantity() * item.getP().getProductPrice()));
        }
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }


    public void addtoCart(ProductEntity p) {

        LOGGER.info(p.getProductName());
        for (Item item : cart) {
            if (item.getP().getProductName().equals(p.getProductName())) {
                item.setQuantity(item.getQuantity() + 1);
                item.setAllquantity(item.getAllquantity() + 1);
                return;
            }
        }

        Item i = new Item();
        i.setQuantity(1);
        i.setAllquantity(i.getAllquantity() + 1);
        i.setP(p);
        cart.add(i);

    }


    public void update() {

    }

    int curr = 0;
    String currName = null;

    public void addMore(int Quantity, ProductEntity p) {
        if (Quantity != 0 && Quantity == (int) Quantity) {
            for (Item item : cart) {
                LOGGER.info(p.getProductName() + " " + Quantity + " " + cart.size() + " " + cartSize + " " + getCartCount());
                if (item.getP().getProductName().equals(p.getProductName())) {
                    if (cart.size() > 1) {
                        if (curr == 0)
                            item.setAllquantity(item.getAllquantity() + (Quantity - curr) - 1);
                        else if (item.getP().getProductName().equals(currName)) {
                            item.setAllquantity(item.getAllquantity() + (Quantity - curr));
                        } else {
                            item.setAllquantity(Quantity + curr);
                        }
                    } else {
                        item.setAllquantity(Quantity);
                        item.setQuantity(Quantity);
                    }
                    LOGGER.info(curr + " " + Quantity + " " + item.getQuantity());
                    if (cart.size() > 1) {
                        curr = item.getQuantity();
                        currName = item.getP().getProductName();
                    }
                }
            }
        }
    }


    public String remove(Item i) {
        for (Item item : cart)
            if (item.equals(i)) {
                cart.remove(item);
                item.setAllquantity(i.getAllquantity() - item.getQuantity());
                break;
            }
        return "cart.xhtml?faces-redirect=true";
    }

    public int getThisQuantity() {
        return thisQuantity;
    }

    public void setThisQuantity(int thisQuantity) {
        this.thisQuantity = thisQuantity;
    }
}
