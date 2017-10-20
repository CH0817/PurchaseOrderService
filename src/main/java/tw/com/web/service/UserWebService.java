package tw.com.web.service;

import tw.com.dao.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * User web service interface
 *
 * @author Rex
 */
@WebService
public interface UserWebService {
    /**
     * 新增
     *
     * @param entity 新增物件
     * @return JSON
     */
    @WebMethod()
    String insert(@WebParam(name = "user") User entity);

    /**
     * 刪除
     *
     * @param id 物件ID
     * @return JSON
     */
    @WebMethod
    String delete(@WebParam(name = "id") String id);

    /**
     * 更新
     *
     * @param entity 更新物件
     * @return JSON
     */
    @WebMethod
    String update(@WebParam(name = "user") User entity);

    /**
     * 登入
     *
     * @param entity 登入物件
     * @return JSON
     */
    @WebMethod
    String login(@WebParam(name = "user") User entity);

    /**
     * 檢查email是否重複
     *
     * @param email email
     * @return JSON
     */
    @WebMethod
    String checkDuplicate(@WebParam(name = "email") String email);

    /**
     * 登出
     *
     * @param userId 用戶id
     * @return JSON
     */
    @WebMethod
    String logout(@WebParam(name = "userId") String userId);
}
