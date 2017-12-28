package privt.gene.service;


import org.springframework.stereotype.Repository;
import privt.gene.dto.User;

/**
 * Created by Gene on 2017/12/22.
 */
public interface UserService {
    public User login(String name,String password);
}
