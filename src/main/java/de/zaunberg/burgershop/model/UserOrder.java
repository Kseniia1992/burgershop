package de.zaunberg.burgershop.model;

import javax.persistence.*;

/**
 * @author ksolodovnik
 */

@Entity
@Table(name = "UserOrder")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;

    private String choice1;
    private String choice2;
    private String choice3;

    private int totalprice;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

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

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
