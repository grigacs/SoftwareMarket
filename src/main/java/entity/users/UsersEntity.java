package entity.users;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by grigacs on 4/7/2016.
 */
@Entity
@Table(name = "users", schema = "softwaremarket")
/*
 * @NamedQueries(
 * 
 * @NamedQuery( name = "listUsers", query = "select u from UsersEntity u" ) )
 */

public class UsersEntity implements Serializable {

	public static class A {
		public static final String USERNAME = "username";
	}

	private int idUser;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Date birthDate;

	@Basic
	@Column(name = "sex")
	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	private boolean sex;

	public UsersEntity() {
	}

	public UsersEntity(String firstName, String lastName, String username, String password, Date birthDate,
			Boolean sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.birthDate = birthDate;
		this.sex = sex;

	}

	@Id
	@Column(name = "id_user")
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Basic
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Basic
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UsersEntity that = (UsersEntity) o;

		if (getIdUser() != that.getIdUser()) return false;
		if (isSex() != that.isSex()) return false;
		if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
			return false;
		if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
			return false;
		if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null)
			return false;
		if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null)
			return false;
		return getBirthDate() != null ? getBirthDate().equals(that.getBirthDate()) : that.getBirthDate() == null;

	}

	@Override
	public int hashCode() {
		int result = getIdUser();
		result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
		result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
		result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
		result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
		result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
		result = 31 * result + (isSex() ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User [userId=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", birthDate=" + birthDate + "]";
	}
}

enum Sex {
	FEMALE, MALE
}
