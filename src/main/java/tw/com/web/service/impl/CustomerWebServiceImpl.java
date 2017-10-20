package tw.com.web.service.impl;

import tw.com.dao.model.Customer;
import tw.com.service.CustomerService;
import tw.com.utils.JsonUtils;
import tw.com.web.service.CustomerWebService;

import javax.annotation.Resource;
import javax.jws.WebService;

/**
 * Customer web service implement
 *
 * @author Rex
 */
@WebService
public class CustomerWebServiceImpl implements CustomerWebService {

    @Resource
    private CustomerService customerService;

    @Override
    public String insert(Customer entity) {
        try {
            return JsonUtils.writeToJson(customerService.insert(entity));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String delete(String id) {
        try {
            return JsonUtils.writeToJson(customerService.delete(id));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String update(Customer entity) {
        try {
            return JsonUtils.writeToJson(customerService.update(entity));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String findById(String id, String userId) {
        return JsonUtils.writeToJson(customerService.findById(id, userId));
    }

    @Override
    public String findByIds(String[] ids, String userId) {
        return JsonUtils.writeToJson(customerService.findByIds(ids, userId));
    }

    @Override
    public String findAll(String userId) {
        return JsonUtils.writeToJson(customerService.findAll(userId));
    }

    @Override
    public String checkDuplicate(String email, String userId) {
        return JsonUtils.writeToJson(customerService.checkDuplicate(email, userId));
    }

}
