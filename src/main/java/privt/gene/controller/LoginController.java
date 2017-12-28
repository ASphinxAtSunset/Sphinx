package privt.gene.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import privt.gene.dto.User;
import privt.gene.service.UserService;
import privt.gene.utils.annotation.ExecuteTime;
import privt.gene.utils.annotation.InvokeLog;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gene on 2017/12/12.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/testq")
    @ExecuteTime
    @InvokeLog(value = "-----进入登录",printArgs = true)
    public String testOntroller(HttpServletRequest request){
        //TODO 校验
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = userService.login(name,password);
        request.getSession().setAttribute("user+IP",user);
        //TODO 判断是否二次登录
        //TODO 放session

        return "index.jsp";
    }
}
