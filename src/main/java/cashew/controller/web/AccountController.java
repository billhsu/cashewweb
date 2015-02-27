package cashew.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Shipeng Xu on 27/1/15.
 */
@Controller
@ControllerAdvice
public class AccountController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/register", method= RequestMethod.GET)
    public String showRegister() {
        return "register";
    }

    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String register() {
        return "register";
    }
}
