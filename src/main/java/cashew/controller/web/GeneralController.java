package cashew.controller.web;

import cashew.service.AccountService;
import cashew.service.SketchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index(ModelMap model) {
        return "welcome";
    }
}
