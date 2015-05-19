package cashew.controller.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Shipeng Xu on 18/3/15.
 */
@Controller
@ControllerAdvice
@Scope("session")
public class UploadController {
    @RequestMapping(value = "/upload", method= RequestMethod.GET)
    public String showUpload() {
        return "upload";
    }
    
    @RequestMapping(value = "/upload", method =RequestMethod.POST)
    public String upload(@RequestParam("uploadFile") MultipartFile uploadFile) {
        return "upload";
    }
}
