package privt.gene.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import privt.gene.dao.UserDao;
import privt.gene.model.User;
import privt.gene.service.UserService;

/**
 * Created by Gene on 2017/12/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User Login(User user) {
        user = userDao.Login(user);
        return user;
    }
}
