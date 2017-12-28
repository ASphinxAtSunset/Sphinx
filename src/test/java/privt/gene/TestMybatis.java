package privt.gene;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import privt.gene.dto.User;
import privt.gene.service.UserService;

/**
 * Created by Gene on 2017/12/23.
 */

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:/applicationContext.xml", "classpath:/springMVC-servlet.xml" })
public class TestMybatis {
    @Test
    public void test(){}
}
