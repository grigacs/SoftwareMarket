package entity.orders;

import entity.products.ProductEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by grigacs on 4/7/2016.
 */
@Entity
@Table(name = "famous_products", schema = "softwaremarket")
public class FamousProductsEntity implements Serializable {
    private int famousProductsId;
    private int productId;
    private int orderId;
    private int saledCount;

    public FamousProductsEntity(int saledCount, int productId, int orderId) {

        this.saledCount = saledCount;
        this.productId = productId;
        this.orderId = orderId;
    }

    public FamousProductsEntity() {
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderProductEntity order_product;

    @Id
    @Column(name = "famous_products_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getFamousProductsId() {
        return famousProductsId;
    }

    public void setFamousProductsId(int famousProductsId) {
        this.famousProductsId = famousProductsId;
    }

    @Basic
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "saled_count")
    public int getSaledCount() {
        return saledCount;
    }

    public void setSaledCount(int saledCount) {
        this.saledCount = saledCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamousProductsEntity that = (FamousProductsEntity) o;

        if (famousProductsId != that.famousProductsId) return false;
        if (productId != that.productId) return false;
        if (orderId != that.orderId) return false;
        if (saledCount != that.saledCount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = famousProductsId;
        result = 31 * result + productId;
        result = 31 * result + orderId;
        result = 31 * result + saledCount;
        return result;
    }
}
