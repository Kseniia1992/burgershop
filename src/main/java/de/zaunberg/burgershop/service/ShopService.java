package de.zaunberg.burgershop.service;

import de.zaunberg.burgershop.model.Role;
import de.zaunberg.burgershop.model.ShopUser;
import de.zaunberg.burgershop.model.UserOrder;

import java.util.List;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 16.11.13 22:43
 */
public interface ShopService {
    List<ShopableItem> getShopableItems();

    Order placeOrder(String... items);

    public void add(UserOrder userOrder);
    public List<UserOrder> findUserOrder(String username);

    public ShopUser findUserByName(String username);
    public void add(ShopUser shopUser);

    public void add(Role role);
    public Role findRoleById(int role_id);
}
