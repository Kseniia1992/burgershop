package de.zaunberg.burgershop.service;

import de.zaunberg.burgershop.dao.OrderDao;
import de.zaunberg.burgershop.dao.RoleDao;
import de.zaunberg.burgershop.dao.UserDao;
import de.zaunberg.burgershop.model.Role;
import de.zaunberg.burgershop.model.ShopUser;
import de.zaunberg.burgershop.model.UserOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 16.11.13 22:47
 */
public class ShopServiceImpl implements ShopService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    private LinkedList<ShopableItem> items;

    private static Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);

    public ShopServiceImpl(){
        items = new LinkedList<ShopableItem>();
        items.add(new ShopableItem("wheat", 585, Category.BREAD));
        items.add(new ShopableItem("wholemeal", 285, Category.BREAD));
        items.add(new ShopableItem("brioche", 585, Category.BREAD));
        items.add(new ShopableItem("burned", 585, Category.BREAD));
        items.add(new ShopableItem("leibniz", 1085, Category.BREAD));

        items.add(new ShopableItem("cow", 1385, Category.MEAT));
        items.add(new ShopableItem("pork", 1185, Category.MEAT));
        items.add(new ShopableItem("lamb", 1584, Category.MEAT));
        items.add(new ShopableItem("dog", 585, Category.MEAT));
        items.add(new ShopableItem("rat", 10, Category.MEAT));

        items.add(new ShopableItem("mushrooms", 285, Category.EXTRAS));
        items.add(new ShopableItem("broccoli", 185, Category.EXTRAS));
        items.add(new ShopableItem("cheese", 85, Category.EXTRAS));
        items.add(new ShopableItem("sauce", 85, Category.EXTRAS));
        items.add(new ShopableItem("cockroach", 2085, Category.EXTRAS));
    }

    @Override
    public List<ShopableItem> getShopableItems() {
        return items;
    }

    @Override
    public Order placeOrder(String... items) {
        //first find the order

        if (items==null)
            throw new IllegalArgumentException("No items for order");

        Order order = new Order();
        for (String item : items){
            order.addItem(findItemByName(item));
        }

        return order;
    }

    private ShopableItem findItemByName(String name){
        for (ShopableItem item : items){
            if (item.getName().equals(name))
                return item;
        }
        throw new IllegalArgumentException("No such shopable item: "+name);
    }

    /**
     * Adds order of user into data base
     * @param userOrder - order object
     */
    @Transactional
    public void add(UserOrder userOrder) {
        orderDao.add(userOrder);
    }

    /**
     * Finds orders of user by user name
     * @param username - user name
     * @return list of orders
     */
    @Transactional
    public List<UserOrder> findUserOrder(String username) {
        return orderDao.findUserOrder(username);
    }

    /**
     * Finds user by user name
     * @param username - user name
     * @return user object
     */
    @Transactional
    public ShopUser findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    /**
     * Adds user into data base
     * @param shopUser - user object
     */
    @Transactional
    public void add(ShopUser shopUser) {
        userDao.add(shopUser);
    }

    /**
     * Adds user role into data base
     * @param role - role object
     */
    @Transactional
    public void add(Role role) {
        roleDao.add(role);
    }

    /**
     * Finds role by id
     * @param role_id - id
     * @return role object
     */
    @Transactional
    public Role findRoleById(int role_id) {
        return roleDao.findRoleById(role_id);
    }

}

