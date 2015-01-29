package de.zaunberg.burgershop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * User role entity
 * @author ksolodovnik
 */

@Entity
public class Role implements Serializable {

    /** id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;

    /** role */
    @NotNull
    private String roleName;

    /** list of users */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<ShopUser> shopUsers;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<ShopUser> getShopUsers() {
        return shopUsers;
    }

    public void setShopUsers(List<ShopUser> shopUsers) {
        this.shopUsers = shopUsers;
    }
}
