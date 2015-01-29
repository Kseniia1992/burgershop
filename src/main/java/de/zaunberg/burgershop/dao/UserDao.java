package de.zaunberg.burgershop.dao;

import de.zaunberg.burgershop.model.ShopUser;

/**
 * @author ksolodovnik
 */
public interface UserDao {
   public ShopUser findUserByName(String username);
   public void add(ShopUser shopUser);
}
