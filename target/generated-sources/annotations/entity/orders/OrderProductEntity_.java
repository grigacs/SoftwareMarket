package entity.orders;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderProductEntity.class)
public abstract class OrderProductEntity_ {

	public static volatile SingularAttribute<OrderProductEntity, Integer> idUser;
	public static volatile SingularAttribute<OrderProductEntity, Integer> orderId;
	public static volatile SingularAttribute<OrderProductEntity, Double> totalPrice;
	public static volatile SingularAttribute<OrderProductEntity, Date> orderDate;
	public static volatile SingularAttribute<OrderProductEntity, String> productsName;
	public static volatile SingularAttribute<OrderProductEntity, Enum> status;

}

