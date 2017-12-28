package privt.gene.service.serviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import privt.gene.TestMybatis;
import privt.gene.dto.User;
import privt.gene.service.UserService;

/**
 * Created by Gene on 2017/12/25.
 */
public class UserServiceImplTest extends TestMybatis {
    @Autowired
    private UserService userService;
    @Test
    public void testUserLogin(){
        User user = new User();
        user.setUserName("a");
        user.setUserPasswd("a");
        //userService.login(user);
    }
}
