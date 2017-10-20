package tw.com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.com.base.service.impl.BaseServiceImpl;
import tw.com.dao.model.User;
import tw.com.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * User service implement
 *
 * @author Rex
 */
@Transactional
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Override
    public String insert(User entity) {
        return super.insert(userMapper, entity);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(userMapper, new User(), id);
    }

    @Override
    public boolean update(User user) {
        return super.update(userMapper, user);
    }

    @Override
    public boolean login(User user) {
        if (userMapper.login(user) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicate(String email) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("email", email);
        return super.checkDuplicate(userMapper, condition);
    }

}
