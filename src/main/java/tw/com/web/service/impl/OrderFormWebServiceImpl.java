package tw.com.web.service.impl;

import org.springframework.util.StringUtils;
import tw.com.dao.model.OrderForm;
import tw.com.dao.model.OrderFormProduct;
import tw.com.service.OrderFormService;
import tw.com.utils.JsonUtils;
import tw.com.web.service.OrderFormWebService;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.List;

/**
 * OrderForm web service implement
 *
 * @author Rex
 */
@WebService
public class OrderFormWebServiceImpl implements OrderFormWebService {

    @Resource
    private OrderFormService orderFormService;

    @Override
    public String insert(OrderForm entity) {
        String id = null;
        try {
            id = orderFormService.insert(entity);
            if (!StringUtils.isEmpty(id)) {
                List<OrderFormProduct> products = entity.getProducts();
                orderFormService.insert(products, id);
            }
            return JsonUtils.writeToJson(id);
        } catch (Exception e) {
            if (!StringUtils.isEmpty(id)) {
                orderFormService.realDelete(id);
            }
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String delete(String id) {
        try {
            return JsonUtils.writeToJson(orderFormService.delete(id));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String update(OrderForm entity) {
        try {
            return JsonUtils.writeToJson(orderFormService.update(entity));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String findById(String id, String userId) {
        return JsonUtils.writeToJson(orderFormService.findById(id, userId));
    }

    @Override
    public String findByIds(String[] ids, String userId) {
        return JsonUtils.writeToJson(orderFormService.findByIds(ids, userId));
    }

    @Override
    public String findAll(String userId) {
        return JsonUtils.writeToJson(orderFormService.findAll(userId));
    }

    @Override
    public String findByProduct(String[] productIds) {
        List<OrderForm> orderForms = orderFormService.findByProduct(productIds);
        return null;
    }

}
