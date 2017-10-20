package tw.com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.com.base.service.impl.BaseServiceImpl;
import tw.com.dao.model.Supplier;
import tw.com.service.SupplierService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Supplier service implement
 *
 * @author Rex
 */
@Transactional
@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService {
    @Override
    public String insert(Supplier entity) {
        return super.insert(supplierMapper, entity);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(supplierMapper, new Supplier(), id);
    }

    @Override
    public boolean update(Supplier supplier) {
        return super.update(supplierMapper, supplier);
    }

    @Override
    public Supplier findById(String id, String userId) {
        //return super.findById(supplierMapper, id, userId);
        return supplierMapper.findById(id, userId);
    }

    @Override
    public List<Supplier> findByIds(String[] ids, String userId) {
        //return super.findByIds(supplierMapper, ids, userId);
        return supplierMapper.findByIds(ids, userId);
    }

    @Override
    public List<Supplier> findAll(String userId) {
        //return super.findAll(supplierMapper, userId);
        return supplierMapper.findAll(userId);
    }

    @Override
    public List<Supplier> findByCondition(Map<String, Object> condition) {
        //return super.findByCondition(supplierMapper, condition);
        return supplierMapper.findByCondition(condition);
    }

    @Override
    public boolean checkDuplicate(String email, String userId) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("email", email);
        condition.put("userId", userId);
        return super.checkDuplicate(supplierMapper, condition);
    }

}
