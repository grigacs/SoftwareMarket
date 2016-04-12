package entity.admin;

import entity.users.UsersEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by grigacs on 4/7/2016.
 */
@Entity
@Table(name = "admin", schema = "softwaremarket")
public class AdminEntity implements Serializable {
    private int idAdmin;
    private int idUser;

    public AdminEntity(int idUser) {
        this.idUser = idUser;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UsersEntity users;

    public AdminEntity() {
    }

    @Id
    @Column(name = "id_admin")
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Basic
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (idAdmin != that.idAdmin) return false;
        if (idUser != that.idUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAdmin;
        result = 31 * result + idUser;
        return result;
    }
}
