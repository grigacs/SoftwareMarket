package entity.products;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by grigacs on 4/7/2016.
 */
@Entity
@Table(name = "product", schema = "softwaremarket")
public class ProductEntity implements Serializable {
    private int productId;
    private String productName;
    private String productPicture;
    private double productPrice;
    private String productVersion;
    private String productDescription;


    public ProductEntity(String productName, String productPicture, double productPrice, String productVersion, String productDescription, int productId) {
        this.productName = productName;
        this.productPicture = productPicture;
        this.productPrice = productPrice;
        this.productVersion = productVersion;
        this.productDescription = productDescription;
        this.productId = productId;
    }

    public ProductEntity() {
    }

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_picture")
    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    @Basic
    @Column(name = "product_price")
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "product_version")
    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    @Basic
    @Column(name = "product_description")
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (productId != that.productId) return false;
        if (Double.compare(that.productPrice, productPrice) != 0) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productPicture != null ? !productPicture.equals(that.productPicture) : that.productPicture != null)
            return false;
        if (productVersion != null ? !productVersion.equals(that.productVersion) : that.productVersion != null)
            return false;
        if (productDescription != null ? !productDescription.equals(that.productDescription) : that.productDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPicture != null ? productPicture.hashCode() : 0);
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (productVersion != null ? productVersion.hashCode() : 0);
        result = 31 * result + (productDescription != null ? productDescription.hashCode() : 0);
        return result;
    }


}
