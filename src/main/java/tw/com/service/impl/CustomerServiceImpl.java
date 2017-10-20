package tw.com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.com.base.service.impl.BaseServiceImpl;
import tw.com.dao.model.Customer;
import tw.com.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Customer service implement
 *
 * @author Rex
 */
@Transactional
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {
    @Override
    public String insert(Customer entity) {
        return super.insert(customerMapper, entity);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(customerMapper, new Customer(), id);
    }

    @Override
    public boolean update(Customer customer) {
        return super.update(customerMapper, customer);
    }

    @Override
    public Customer findById(String id, String userId) {
        //return super.findById(customerMapper, id, userId);
        return customerMapper.findById(id, userId);
    }

    @Override
    public List<Customer> findByIds(String[] ids, String userId) {
        //return super.findByIds(customerMapper, ids, userId);
        return customerMapper.findByIds(ids, userId);
    }

    @Override
    public List<Customer> findAll(String userId) {
        //return super.findAll(customerMapper, userId);
        return customerMapper.findAll(userId);
    }

    @Override
    public List<Customer> findByCondition(Map<String, Object> condition) {
        //return super.findByCondition(customerMapper, condition);
        return customerMapper.findByCondition(condition);
    }

    @Override
    public boolean checkDuplicate(String email, String userId) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("email", email);
        condition.put("userId", userId);
        return super.checkDuplicate(customerMapper, condition);
    }

}
