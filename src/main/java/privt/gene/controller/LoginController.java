package privt.gene.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import privt.gene.utils.annotation.ExecuteTime;
import privt.gene.utils.annotation.InvokeLog;

/**
 * Created by Gene on 2017/12/12.
 */
@Controller
public class LoginController {
    @RequestMapping("/test")
    @ExecuteTime
    @InvokeLog(value = "-----进入登录",printArgs = true)
    public String testController(String string){
        System.out.println("------------------------------------");
        return "index.jsp";
    }
}
