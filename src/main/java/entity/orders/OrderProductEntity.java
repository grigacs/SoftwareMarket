package entity.orders;

import entity.users.UsersEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by grigacs on 4/7/2016.
 */
@Entity
@Table(name = "order_product", schema = "softwaremarket")
public class OrderProductEntity implements Serializable {
    private int orderId;
    private int idUser;
    private Date orderDate;
    private double totalPrice;
    private String productsName;
    private String status;

    public OrderProductEntity(int idUser, Date orderDate, double totalPrice, String productsName, String status) {
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.productsName = productsName;
        this.status = status;
        this.idUser = idUser;
    }



    public OrderProductEntity() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UsersEntity users;


    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "order_date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "total_price")
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "products_name")
    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderProductEntity that = (OrderProductEntity) o;

        if (orderId != that.orderId) return false;
        if (idUser != that.idUser) return false;
        if (Double.compare(that.totalPrice, totalPrice) != 0) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (productsName != null ? !productsName.equals(that.productsName) : that.productsName != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderId;
        result = 31 * result + idUser;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (productsName != null ? productsName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }


}
