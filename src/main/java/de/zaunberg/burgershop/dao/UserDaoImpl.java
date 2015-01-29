package de.zaunberg.burgershop.dao;

import de.zaunberg.burgershop.model.ShopUser;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ksolodovnik
 */
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ShopUser findUserByName(String username) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ShopUser.class);
        criteria.add(Restrictions.eq("username", username));
        return (ShopUser) criteria.uniqueResult();
    }

    @Override
    public void add(ShopUser shopUser) {
        sessionFactory.getCurrentSession().save(shopUser);
    }
}
