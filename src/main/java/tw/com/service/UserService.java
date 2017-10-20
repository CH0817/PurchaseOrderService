package tw.com.service;

import tw.com.dao.model.User;

/**
 * User service
 *
 * @author Rex
 */
public interface UserService {

    /**
     * 新增
     *
     * @param entity 新增物件
     * @return id
     */
    String insert(User entity);

    /**
     * 刪除
     *
     * @param id 物件ID
     * @return result
     */
    boolean delete(String id);

    /**
     * 更新
     *
     * @param user 更新物件
     * @return result
     */
    boolean update(User user);

    /**
     * 登入
     *
     * @param user 登入物件
     * @return result
     */
    boolean login(User user);

    /**
     * 檢查email是否重複
     *
     * @param email email
     * @return result
     */
    boolean checkDuplicate(String email);

}
