package cashew.controller.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Shipeng Xu on 18/3/15.
 */
@Controller
@ControllerAdvice
@Scope("session")
public class UploadController {
    @RequestMapping(value="/upload", method= RequestMethod.GET)
    public String showUpload() {
        return "upload";
    }
}
