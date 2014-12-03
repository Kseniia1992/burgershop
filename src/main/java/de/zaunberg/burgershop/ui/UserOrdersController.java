package de.zaunberg.burgershop.ui;

import de.zaunberg.burgershop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author ksolodovnik
 */
@Controller
public class UserOrdersController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("/userOrders.html")
    public String userOrders(HttpServletRequest request){
      //  UserOrder userOrder = new UserOrder();
        Principal principal = request.getUserPrincipal();
        request.setAttribute("userId",shopService.findUserOrder(principal.getName()));

        return "orders";
    }
}
