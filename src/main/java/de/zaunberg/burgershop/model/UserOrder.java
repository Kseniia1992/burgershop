package de.zaunberg.burgershop.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User order entity
 * @author ksolodovnik
 */

@Entity
@Table(name = "UserOrder")
public class UserOrder implements Serializable{

    /** id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;

    /** first choice in menu for burger */
    private String choice1;

    /** second choice in menu for burger */
    private String choice2;

   /** third choice in menu for burger */
    private String choice3;

    /** total price for burger */
    private String totalprice;

    /** user */
    @ManyToOne
    @JoinColumn(name = "username")
    private ShopUser shopUser;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public ShopUser getShopUser() {
        return shopUser;
    }

    public void setShopUser(ShopUser shopUser) {
        this.shopUser = shopUser;
    }
}
