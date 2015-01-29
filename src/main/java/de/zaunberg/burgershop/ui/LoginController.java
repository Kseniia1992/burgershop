package de.zaunberg.burgershop.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Login controller
 * @author ksolodovnik
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String doLogin() {
        return "login";
    }

}
