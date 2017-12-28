package privt.gene;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import privt.gene.dto.User;
import privt.gene.service.serviceimpl.UserServiceImpl;

/**
 * Created by Gene on 2017/12/25.
 */
public class TestDisk extends TestCase{

    // 测试mybatis spring 通过数据映射来 映射来实现
    @Test
    public void  testMybatis(){
        User user = new User();
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userServiceImpl= (UserServiceImpl)act.getBean("userServiceImpl");
        User user1 = userServiceImpl.login("a","a");
        System.out.println("name:"+user1.getUserName()+"  password:"+user1.getUserPasswd());
    }
}
