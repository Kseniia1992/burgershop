package de.zaunberg.burgershop.ui;

import de.zaunberg.burgershop.model.UserOrder;
import de.zaunberg.burgershop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * Order controller
 * @author ksolodovnik
 */
@Controller
public class UserOrdersController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("/userOrders.html")
    public String userOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal principal = request.getUserPrincipal();
        List<UserOrder> list = shopService.findUserOrder(principal.getName());
        request.setAttribute("orders",list);
    //    request.getRequestDispatcher("orders.jsp").forward(request,response);

        return "orders";
    }
}
