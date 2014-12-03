package de.zaunberg.burgershop.dao;

import de.zaunberg.burgershop.model.User;

/**
 * @author ksolodovnik
 */
public interface UserDao {
   public User findUserByName(String username);
}
