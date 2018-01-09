package privt.gene.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import privt.gene.constant.userconstant.UserConstant;
import privt.gene.dto.User;
import privt.gene.model.UserSessionInfo;
import privt.gene.service.UserService;
import privt.gene.utils.annotation.ExecuteTime;
import privt.gene.utils.annotation.InvokeLog;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Gene on 2017/12/12.
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    @ExecuteTime
    //@InvokeLog(value = "-----进入登录",start = "【调用开始】========",printArgs = true)
    @ResponseBody
    public void testOntroller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("进入登录方法");
        HttpSession session = request.getSession();
        //TODO 校验
        UserSessionInfo userSessionInfo = new UserSessionInfo();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //若未搜索到用户 sql返回空对象还是Null?
        User user=null;
        try{
            user = userService.login(name,password);
        }catch (Exception e){
            System.out.println(e);
            logger.error("未知异常-----"+e);
            request.setAttribute("msg", "未知异常!");
            request.setAttribute("msg", "用户名或密码不正确！");
            //依旧跳转登录页面
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }finally {

        }
        String IP;
        if (request.getRemoteAddr()!=null){
            IP = request.getRemoteAddr();
        }else{
            IP = request.getHeader("x-forwarded-for");
        }
        if(user!=null){
            userSessionInfo.setUserName(user.getUserName());
            userSessionInfo.setIP(IP);
        }
        System.out.println(session.getAttribute(UserConstant.USER_INFO));
        //TODO 判断是否二次登录,否则放session
        if (session.getAttribute(UserConstant.USER_INFO)==null){
            session.setAttribute(UserConstant.USER_INFO,user);
        }else{
            request.setAttribute("msg", "请勿重复登录!");
        }
        //跳转登录后页面
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
