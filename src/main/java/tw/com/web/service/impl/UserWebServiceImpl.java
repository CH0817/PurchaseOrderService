package tw.com.web.service.impl;

import tw.com.dao.model.User;
import tw.com.service.UserService;
import tw.com.utils.JsonUtils;
import tw.com.web.service.UserWebService;

import javax.annotation.Resource;
import javax.jws.WebService;

/**
 * User web service implement
 *
 * @author Rex
 */
@WebService
public class UserWebServiceImpl implements UserWebService {

    @Resource
    private UserService userService;

    @Override
    public String insert(User entity) {
        try {
            return JsonUtils.writeToJson(userService.insert(entity));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String delete(String id) {
        try {
            return JsonUtils.writeToJson(userService.delete(id));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String update(User entity) {
        try {
            return JsonUtils.writeToJson(userService.update(entity));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String login(User entity) {
        // TODO: 2016/5/8 回傳token???
        return JsonUtils.writeToJson(userService.login(entity));
    }

    @Override
    public String checkDuplicate(String email) {
        return JsonUtils.writeToJson(userService.checkDuplicate(email));
    }

    @Override
    public String logout(String userId) {
        // TODO: 2016/5/8
        return null;
    }

}
