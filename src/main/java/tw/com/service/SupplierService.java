package tw.com.service;

import tw.com.base.service.BaseService;
import tw.com.dao.model.Supplier;

/**
 * Supplier service
 *
 * @author Rex
 */
public interface SupplierService extends BaseService<Supplier> {
    /**
     * 檢查email是否重複
     *
     * @param email email
     * @return is success
     */
    boolean checkDuplicate(String email, String userId);

}
