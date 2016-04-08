package entity.products;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductEntity.class)
public abstract class ProductEntity_ {

	public static volatile SingularAttribute<ProductEntity, String> productVersion;
	public static volatile SingularAttribute<ProductEntity, Integer> productId;
	public static volatile SingularAttribute<ProductEntity, String> productPicture;
	public static volatile SingularAttribute<ProductEntity, String> productName;
	public static volatile SingularAttribute<ProductEntity, Double> productPrice;
	public static volatile SingularAttribute<ProductEntity, String> productDescription;

}

