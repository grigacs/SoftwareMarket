package entity.products;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by grigacs on 4/7/2016.
 */
@Entity
@Table(name = "product_category", schema = "softwaremarket")
public class ProductCategoryEntity implements Serializable {
    private int categoryId;
    private int productId;
    private String categoryName;
    private String categoryDescription;

    public ProductCategoryEntity(String categoryName, String categoryDescription, ProductEntity product) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.product = product;
    }

    public ProductCategoryEntity() {
    }

    @Id
    @Column(name = "category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Basic
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "category_description")
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategoryEntity that = (ProductCategoryEntity) o;

        if (categoryId != that.categoryId) return false;
        if (productId != that.productId) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;
        if (categoryDescription != null ? !categoryDescription.equals(that.categoryDescription) : that.categoryDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + productId;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (categoryDescription != null ? categoryDescription.hashCode() : 0);
        return result;
    }
}
