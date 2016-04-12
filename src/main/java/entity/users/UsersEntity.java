package entity.users;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by grigacs on 4/7/2016.
 */
@Entity
@Table(name = "users", schema = "softwaremarket")
@NamedQueries(
        @NamedQuery(
                name = "listUsers",
                query = "select u from UsersEntity u"
        )
)
public class UsersEntity implements Serializable {
    private int idUser;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    public UsersEntity() {
    }

    public UsersEntity(String firstName, String lastName, String username, String password, Date birthDate, Sex sex) {
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

    @Basic
    @Column(name = "sex")
    public Enum getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idUser != that.idUser) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User [userId=" + idUser + ", firstName=" + firstName
                + ", lastName=" + lastName + ", username=" + username + ", birthDate="
                + birthDate + "]";
    }
}



enum Sex{
  FEMALE, MALE
}

