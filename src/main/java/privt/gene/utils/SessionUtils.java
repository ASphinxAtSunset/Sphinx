package privt.gene.utils;

import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Gene on 2018/1/3.
 */
public class SessionUtils {
    private static HttpSession session;
    public SessionUtils(HttpSession session){
        this.session = session;
    }
    public static boolean dupSession(String sessionId){
        //TODO 校验
        return session.getId().equals(sessionId);
    }
}
