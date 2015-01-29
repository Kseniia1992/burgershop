package de.zaunberg.burgershop.dao;

import de.zaunberg.burgershop.model.UserOrder;

import java.util.List;

/**
 * @author ksolodovnik
 */
public interface OrderDao {
    public void add(UserOrder userOrder);
    public List<UserOrder> findUserOrder(String username);
}
