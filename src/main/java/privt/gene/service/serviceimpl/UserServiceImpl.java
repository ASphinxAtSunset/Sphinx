package privt.gene.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import privt.gene.dao.UserDao;
import privt.gene.dto.User;
import privt.gene.service.UserService;

/**
 * Created by Gene on 2017/12/22.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String name,String password) {
        User user = (User)userDao.login(name,password);
        return user;
        //return null;
    }
}
