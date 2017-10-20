package tw.com.service;

import tw.com.base.service.BaseService;
import tw.com.dao.model.Product;

import java.util.List;

/**
 * Product service
 *
 * @author Rex
 */
public interface ProductService extends BaseService<Product> {

    List<Product> findBySupplier(String[] supplierIds);

    boolean checkDuplicate(String name, String userId);

}
