package cashew.controller.web;

import cashew.entities.Account;
import cashew.service.AccountService;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/")
    public String index() {
        Account account = accountService.createAccount();
        Random randomGenerator = new Random();
        account.setId(randomGenerator.nextLong());
        account.setEmail("aa@aa" + randomGenerator.nextLong()+".com");
        account.setUsername("bill");
        account.setPassword("passwd");
        account.setDateJoined(new Date());
        accountService.saveAccount(account);
        Collection<Account> accounts = accountService.findAccounts();
        System.out.println(accounts.toString());
        return "welcome";
    }
}
