package tw.com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.com.base.service.impl.BaseServiceImpl;
import tw.com.dao.model.Product;
import tw.com.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Product service implement
 *
 * @author Rex
 */
@Transactional
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Override
    public boolean checkDuplicate(String name, String userId) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("name", name);
        condition.put("userId", userId);
        return super.checkDuplicate(productMapper, condition);
    }

    @Override
    public String insert(Product entity) {
        return super.insert(productMapper, entity);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(productMapper, new Product(), id);
    }

    @Override
    public boolean update(Product entity) {
        return super.update(productMapper, entity);
    }

    @Override
    public Product findById(String id, String userId) {
        //return super.findById(productMapper, id, userId);
        return productMapper.findById(id, userId);
    }

    @Override
    public List<Product> findByIds(String[] ids, String userId) {
        //return super.findByIds(productMapper, ids, userId);
        return productMapper.findByIds(ids, userId);
    }

    @Override
    public List<Product> findAll(String userId) {
        //return super.findAll(productMapper, userId);
        return productMapper.findAll(userId);
    }

    @Override
    public List<Product> findByCondition(Map<String, Object> condition) {
        //return super.findByCondition(productMapper, condition);
        return productMapper.findByCondition(condition);
    }

    @Override
    public List<Product> findBySupplier(String[] supplierIds) {
        return productMapper.findBySupplier(supplierIds);
    }
}
