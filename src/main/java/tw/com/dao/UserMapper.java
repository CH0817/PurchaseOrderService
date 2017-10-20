package tw.com.dao;

import tw.com.base.mapper.BaseTableMapper;
import tw.com.dao.model.User;

public interface UserMapper extends BaseTableMapper<User> {

    int login(User user);

}