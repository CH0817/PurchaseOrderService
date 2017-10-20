package tw.com.service;

import tw.com.base.service.BaseService;
import tw.com.dao.model.Customer;

/**
 * Customer service
 *
 * @author Rex
 */
public interface CustomerService extends BaseService<Customer> {
    /**
     * 檢查email是否重複
     *
     * @param email email
     * @return is success
     */
    boolean checkDuplicate(String email, String userId);

}
