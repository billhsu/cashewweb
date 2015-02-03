package cashew.controller.web;

import cashew.entities.Account;
import cashew.entities.Sketch;
import cashew.service.AccountService;
import cashew.service.SketchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

/**
 * Created by Shipeng Xu on 25/1/15.
 */
@Controller
@ControllerAdvice
public class GeneralController {
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private SketchService sketchService;
    
    @RequestMapping("/")
    public String index() {
        return "welcome";
    }
    
    @RequestMapping("/addRandomAccount")
    @ResponseBody
    public String addRandomAccount() {
        Account account = accountService.createAccount();
        Random randomGenerator = new Random();
        account.setEmail("aa@aa" + randomGenerator.nextLong()+".com");
        account.setUsername("bill" + randomGenerator.nextLong());
        account.setPassword("passwd");
        account.setDateJoined(new Date());
        accountService.saveAccount(account);
        return account.toString();
    }
}
