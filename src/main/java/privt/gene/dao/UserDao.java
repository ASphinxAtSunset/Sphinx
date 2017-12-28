package privt.gene.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import privt.gene.dto.User;

/**
 * Created by Gene on 2017/12/22.
 */
public interface UserDao {

    //public User login(User user);

    public User login(@Param("userName") String name, @Param("password") String password);
}
