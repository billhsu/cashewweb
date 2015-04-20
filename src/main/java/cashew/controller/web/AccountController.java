package cashew.controller.web;

import cashew.controller.form.LoginForm;
import cashew.controller.form.SignupForm;
import cashew.entities.Account;
import cashew.service.AccountService;
import cashew.service.CryptoService;
import cashew.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
@Scope("session")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    CryptoService cryptoService;

    @Autowired
    UserSession userSession;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String showLogin(LoginForm loginForm) {
        return "login";
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Account loginAccount = accountService.findAccountByEmail(loginForm.getEmail());
        if (loginAccount!=null &&
                loginAccount.getPassword().equals(
                        cryptoService.hashString(loginForm.getPassword() + loginAccount.getSalt())
                )) {
            userSession.setUserEmail(loginAccount.getEmail());
            userSession.setUserNickname(loginAccount.getNickname());
            return "redirect:/";
        } else {
            bindingResult.rejectValue("password", "error.user", "Email address or password incorrect.");
            return "login";
        }

    }

    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public String showSignup(SignupForm signupForm) {
        return "signup";
    }

    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public String signup(@Valid SignupForm signupForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !signupForm.getPassword().equals(signupForm.getRePassword())) {
            if(!signupForm.getPassword().equals(signupForm.getRePassword())) {
                bindingResult.rejectValue("rePassword", "error.user", "Passwords not match.");
            }
            return "signup";
        }
        Account accountByEmail = accountService.findAccountByEmail(signupForm.getEmail());
        Account accountByNickname = accountService.findAccountByNickname(signupForm.getNickname());
        if(accountByEmail != null || accountByNickname != null) {
            if(accountByEmail != null) bindingResult.rejectValue("email", "error.user", "Email already registered.");
            if(accountByNickname != null) bindingResult.rejectValue("nickname", "error.user", "Nickname already registered.");
            return "signup";
        }
        Account account = accountService.createAccount();
        account.setEmail(signupForm.getEmail());
        account.setPassword(signupForm.getPassword());
        account.setNickname(signupForm.getNickname());
        account.setDateJoined(new Date());
        account.setAccountStatus(Account.AccountStatus.PENDING);
        accountService.saveAccount(account);
        return "redirect:/login";
    }

    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logout() {
        userSession.invalidateSession();
        return "redirect:/";
    }
}
