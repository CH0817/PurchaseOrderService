package tw.com.web.service.impl;

import tw.com.dao.model.Supplier;
import tw.com.service.SupplierService;
import tw.com.utils.JsonUtils;
import tw.com.web.service.SupplierWebService;

import javax.annotation.Resource;
import javax.jws.WebService;

/**
 * Supplier web service implement
 *
 * @author Rex
 */
@WebService
public class SupplierWebServiceImpl implements SupplierWebService {

    @Resource
    private SupplierService supplierService;

    @Override
    public String insert(Supplier entity) {
        try {
            return JsonUtils.writeToJson(supplierService.insert(entity));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String delete(String id) {
        try {
            return JsonUtils.writeToJson(supplierService.delete(id));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String update(Supplier entity) {
        try {
            return JsonUtils.writeToJson(supplierService.update(entity));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String findById(String id, String userId) {
        return JsonUtils.writeToJson(supplierService.findById(id, userId));
    }

    @Override
    public String findByIds(String[] ids, String userId) {
        return JsonUtils.writeToJson(supplierService.findByIds(ids, userId));
    }

    @Override
    public String findAll(String userId) {
        return JsonUtils.writeToJson(supplierService.findAll(userId));
    }

    @Override
    public String checkDuplicate(String email, String userId) {
        return JsonUtils.writeToJson(supplierService.checkDuplicate(email, userId));
    }

}
