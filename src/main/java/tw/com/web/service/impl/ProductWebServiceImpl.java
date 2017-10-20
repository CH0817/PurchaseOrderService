package tw.com.web.service.impl;

import tw.com.dao.model.Product;
import tw.com.service.ProductService;
import tw.com.utils.JsonUtils;
import tw.com.web.service.ProductWebService;

import javax.annotation.Resource;
import javax.jws.WebService;

/**
 * User web service implement
 *
 * @author Rex
 */
@WebService
public class ProductWebServiceImpl implements ProductWebService {

    @Resource
    private ProductService productService;

    @Override
    public String insert(Product entity) {
        // FIXME: 2016/5/9 庫存是否能更動?
        try {
            return JsonUtils.writeToJson(productService.insert(entity));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String delete(String id) {
        try {
            return JsonUtils.writeToJson(productService.delete(id));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String update(Product entity) {
        try {
            return JsonUtils.writeToJson(productService.update(entity));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String findById(String id, String userId) {
        return JsonUtils.writeToJson(productService.findById(id, userId));
    }

    @Override
    public String findByIds(String[] ids, String userId) {
        return JsonUtils.writeToJson(productService.findByIds(ids, userId));
    }

    @Override
    public String findAll(String userId) {
        return JsonUtils.writeToJson(productService.findAll(userId));
    }

    @Override
    public String findBySupplier(String[] supplierIds) {
        // FIXME: 2016/5/9 要加入userId
        return JsonUtils.writeToJson(productService.findBySupplier(supplierIds));
    }

    @Override
    public String checkDuplicate(String name, String userId) {
        return JsonUtils.writeToJson(productService.checkDuplicate(name, userId));
    }
}
