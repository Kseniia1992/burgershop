package de.zaunberg.burgershop.ui;

import de.zaunberg.burgershop.dao.UserDao;
import de.zaunberg.burgershop.dao.UserDaoImpl;
import de.zaunberg.burgershop.model.User;
import de.zaunberg.burgershop.model.UserOrder;
import de.zaunberg.burgershop.service.Order;
import de.zaunberg.burgershop.service.ShopService;
import de.zaunberg.burgershop.service.ShopableItem;
import net.anotheria.util.NumberUtils;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.LinkedList;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 17.11.13 15:16
 */
@Controller
public class OrderController {
    @Autowired
    private ShopService service;

    @Autowired
    private UserDao userDao;

    private static Logger log = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping(value = "/order.html")
    public String order(HttpServletRequest request, @RequestParam()String choice1, @RequestParam String choice2, @RequestParam String choice3){

        log.debug("Incoming order "+choice1+", "+choice2+", "+choice3);
        Order order = service.placeOrder(choice1, choice2, choice3);

        log.debug("Placed order "+order);

        LinkedList<String> orderedItems = new LinkedList<String>();
        for (ShopableItem item : order.getItems()){
            orderedItems.add(item.getName());
        }
        request.setAttribute("ordereditems", orderedItems);
        request.setAttribute("totalPrice", NumberUtils.currencyFormat((double) order.getTotalPrice() / 100, ','));
  /*
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        String uname = (String) session.getAttribute("username");
        System.out.println(uname);
        UserDaoImpl udi = new UserDaoImpl();
        User u = userDao.findUserByName("user1"); */

        Principal principal = request.getUserPrincipal();
        User u = userDao.findUserByName(principal.getName());

        UserOrder userOrder = new UserOrder();
        userOrder.setChoice1(choice1);
        userOrder.setChoice2(choice2);
        userOrder.setChoice3(choice3);
        userOrder.setTotalprice(order.getTotalPrice() / 100);
        userOrder.setUser(u);
        service.add(userOrder);

        return "confirmation";
    }

}