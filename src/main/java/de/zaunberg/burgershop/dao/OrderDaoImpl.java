package de.zaunberg.burgershop.dao;

import de.zaunberg.burgershop.model.UserOrder;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserOrder.class);
        criteria.add(Restrictions.eqProperty("username", username));
        List<UserOrder> results = criteria.list();
        return results;
    }

}
