package privt.gene.dao;

import org.springframework.stereotype.Service;
import privt.gene.model.User;

/**
 * Created by Gene on 2017/12/22.
 */
@Service
public interface UserDao {
    public User Login(User user);
}
