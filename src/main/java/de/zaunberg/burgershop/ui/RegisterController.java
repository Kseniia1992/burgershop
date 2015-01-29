package de.zaunberg.burgershop.ui;

import de.zaunberg.burgershop.model.Role;
import de.zaunberg.burgershop.model.ShopUser;
import de.zaunberg.burgershop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Register controller
 * @author ksolodovnik
 */

@Controller
public class RegisterController {
    @Autowired
    private ShopService service;

    /** Adds user to model */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("user", new ShopUser());
    return "register";
    }

    /** Adds user to data base*/
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user")ShopUser shopUser,
                          BindingResult result) {
            if (result.hasErrors()) {
                return "register";
            } else {
                Role role = new Role();
                role.setRoleName("User");

                ArrayList<Role> list_role = new ArrayList<Role>();
                list_role.add(role);
                shopUser.setRoles(list_role);

                ArrayList<ShopUser> list_user = new ArrayList<ShopUser>();
                list_user.add(shopUser);
                role.setShopUsers(list_user);


                service.add(shopUser);
                service.add(role);
                return "redirect:login";

            }

    }
}
