package de.zaunberg.burgershop.dao;

import de.zaunberg.burgershop.model.Role;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ksolodovnik
 */
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public Role findRoleById(int role_id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
        criteria.add(Restrictions.eq("role_id", role_id));
        return (Role) criteria.uniqueResult();
    }
}
