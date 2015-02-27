package cashew.controller.web;

import cashew.entities.Account;
import cashew.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import java.util.Date;

/**
 * Created by Shipeng Xu on 27/1/15.
 */
@Controller
@ControllerAdvice
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/register", method= RequestMethod.GET)
    public String showRegister(NewAccount newAccount) {
        return "register";
    }

    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String register(@Valid NewAccount newAccount, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !newAccount.getPassword().equals(newAccount.getRePassword())) {
            return "register";
        }
        Account account = accountService.createAccount();
        account.setEmail(newAccount.getEmail());
        account.setPassword(newAccount.getPassword());
        account.setNickname(newAccount.getNickname());
        account.setDateJoined(new Date());
        account.setAccountStatus(Account.AccountStatus.PENDING);
        accountService.saveAccount(account);
        return "redirect:/";
    }
}
