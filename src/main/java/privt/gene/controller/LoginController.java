package privt.gene.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gene on 2017/12/12.
 */
@Controller
public class LoginController {
    @RequestMapping("/test")
    public String testController(String string){
        System.out.println("------------------------------------");
        return "index.jsp";
    }
}
