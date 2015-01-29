package de.zaunberg.burgershop.dao;

import de.zaunberg.burgershop.model.UserOrder;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ksolodovnik
 */
public class OrderDaoImpl implements OrderDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(UserOrder userOrder) {
        sessionFactory.getCurrentSession().save(userOrder);
    }

    @Override
    public List<UserOrder> findUserOrder(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery(" from UserOrder uo inner join uo.shopUser as u where u.username = :username");
        query.setParameter("username",username);
        List result = query.list();
        return result;
    }

}
