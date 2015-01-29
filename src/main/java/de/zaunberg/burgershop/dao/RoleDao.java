package de.zaunberg.burgershop.dao;

import de.zaunberg.burgershop.model.Role;

/**
 * @author ksolodovnik
 */
public interface RoleDao {
    public void add(Role role);
    public Role findRoleById(int role_id);
}
