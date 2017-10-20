package tw.com.dao;

import tw.com.base.mapper.BaseMappingTableMapper;
import tw.com.dao.model.OrderFormProduct;

import java.util.List;

public interface OrderFormProductMapper extends BaseMappingTableMapper<OrderFormProduct> {

    int deleteByOrderForm(String orderFormId);

    int deleteByProduct(String productId);

    List<OrderFormProduct> findByOrderForm(String orderFormId);

    List<OrderFormProduct> findByProduct(String productId);

}