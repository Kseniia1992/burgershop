package de.zaunberg.burgershop.model;

import de.zaunberg.burgershop.validator.UniqueUsername;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * User entity
 * @author ksolodovnik
 */

@Entity
public class ShopUser implements Serializable{

    /** login */
    @Id
    @NotEmpty(message = "Please enter your login")
    @Size(min = 3, max = 14, message = "Your login must be between 3 and 14 characters")
    @UniqueUsername(message = "Such user already exists. Enter another username.")
    private String username;

    /** password */
    @NotEmpty(message = "Please enter your password")
    @Size(min = 3, max = 14, message = "Your password must be between 3 and 14 characters")
    private String password;

    /** list of user roles */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "UsersAndRoles", joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    /** list of user orders */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shopUser")
    private List<UserOrder> orders;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<UserOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<UserOrder> orders) {
        this.orders = orders;
    }
}
