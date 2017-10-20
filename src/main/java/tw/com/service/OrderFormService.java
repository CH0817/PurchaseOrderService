package tw.com.service;

import tw.com.base.service.BaseService;
import tw.com.dao.model.OrderForm;
import tw.com.dao.model.OrderFormProduct;

import java.util.List;

/**
 * Supplier service
 *
 * @author Rex
 */
public interface OrderFormService extends BaseService<OrderForm> {

    void insert(List<OrderFormProduct> entities, String orderFromId);

    boolean realDelete(String id);

    List<OrderForm> findByProduct(String[] productIds);
}
