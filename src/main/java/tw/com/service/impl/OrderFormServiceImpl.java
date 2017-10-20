package tw.com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.com.base.service.impl.BaseServiceImpl;
import tw.com.dao.model.OrderForm;
import tw.com.dao.model.OrderFormProduct;
import tw.com.service.OrderFormService;

import java.util.List;
import java.util.Map;

/**
 * OrderForm service implement
 *
 * @author Rex
 */
@Transactional
@Service
public class OrderFormServiceImpl extends BaseServiceImpl<OrderForm> implements OrderFormService {
    @Override
    public String insert(OrderForm entity) {
        return super.insert(orderFormMapper, entity);
    }

    @Override
    public void insert(List<OrderFormProduct> entities, String orderFromId) {
        entities.stream().forEach(orderFormProduct -> {
            orderFormProduct.setOrderFormId(orderFromId);
            super.insert(orderFormProductMapper, orderFormProduct);
        });
    }

    @Override
    public boolean delete(String id) {
        return super.delete(orderFormMapper, new OrderForm(), id);
    }

    @Override
    public boolean realDelete(String id) {
        return super.realDelete(orderFormMapper, id);
    }

    @Override
    public boolean update(OrderForm orderForm) {
        //先delete全部OrderFormProduct再insert
        orderFormProductMapper.deleteByOrderForm(orderForm.getId());
        this.insert(orderForm.getProducts(), orderForm.getId());
        return super.update(orderFormMapper, orderForm);
    }

    @Override
    public OrderForm findById(String id, String userId) {
        OrderForm orderForm = orderFormMapper.findById(id, userId);
        orderForm.setProducts(orderFormProductMapper.findByOrderForm(orderForm.getId()));
        return orderForm;
    }

    @Override
    public List<OrderForm> findByIds(String[] ids, String userId) {
        List<OrderForm> orderForms = orderFormMapper.findByIds(ids, userId);
        setProduct(orderForms);
        return orderForms;
    }

    @Override
    public List<OrderForm> findAll(String userId) {
        List<OrderForm> orderForms = orderFormMapper.findAll(userId);
        setProduct(orderForms);
        return orderForms;
    }

    @Override
    public List<OrderForm> findByCondition(Map<String, Object> condition) {
        List<OrderForm> orderForms = orderFormMapper.findByCondition(condition);
        setProduct(orderForms);
        return orderForms;
    }

    @Override
    public List<OrderForm> findByProduct(String[] productIds) {
        // FIXME: 2016/5/10 
        return null;
    }

    private void setProduct(List<OrderForm> orderForms) {
        orderForms
                .forEach(orderForm -> orderForm.setProducts(orderFormProductMapper.findByOrderForm(orderForm.getId())));
    }

}
