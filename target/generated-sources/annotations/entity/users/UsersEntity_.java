package entity.users;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsersEntity.class)
public abstract class UsersEntity_ {

	public static volatile SingularAttribute<UsersEntity, Integer> idUser;
	public static volatile SingularAttribute<UsersEntity, String> firstName;
	public static volatile SingularAttribute<UsersEntity, String> lastName;
	public static volatile SingularAttribute<UsersEntity, String> password;
	public static volatile SingularAttribute<UsersEntity, Enum> sex;
	public static volatile SingularAttribute<UsersEntity, Date> birthDate;
	public static volatile SingularAttribute<UsersEntity, String> username;

}

