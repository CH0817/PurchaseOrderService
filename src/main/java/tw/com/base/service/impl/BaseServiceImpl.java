package tw.com.base.service.impl;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tw.com.base.mapper.BaseMappingTableMapper;
import tw.com.base.mapper.BaseTableMapper;
import tw.com.base.model.BaseModel;
import tw.com.base.model.BaseNoPropertyModel;
import tw.com.dao.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Service base implement
 *
 * @author Rex
 */
// FIXME: 2016/5/9 要把find開頭的method全部刪除，沒有必要
@SuppressWarnings("unchecked")
public abstract class BaseServiceImpl<T> {

    @Resource
    protected UserMapper userMapper;
    @Resource
    protected ProductMapper productMapper;
    @Resource
    protected CustomerMapper customerMapper;
    @Resource
    protected SupplierMapper supplierMapper;
    @Resource
    protected OrderFormMapper orderFormMapper;
    @Resource
    protected OrderFormProductMapper orderFormProductMapper;
    @Resource
    protected PurchaseFormMapper purchaseFormMapper;
    @Resource
    protected PurchaseQuantityMapper purchaseQuantityMapper;

    protected <B extends BaseModel> String checkInsertData(B entity) {
        if (StringUtils.isEmpty(entity.getId())) {
            String id = UUID.randomUUID().toString();
            entity.setId(id);
            entity.setCreateDate(new Date());
            entity.setRemove(0);
            return id;
        }
        return null;
    }

    protected <M extends BaseTableMapper, B extends BaseModel> String insert(M mapper, B entity) {
        boolean result = false;
        String id = checkInsertData(entity);
        if (!StringUtils.isEmpty(id)) {
            if (mapper.insert(entity) == 1) {
                result = true;
            }
        }
        if (result) {
            return id;
        }
        return null;
    }

    protected <M extends BaseMappingTableMapper, B extends BaseNoPropertyModel> void insert(M mapper, B entity) {
        mapper.insert(entity);
    }

    protected <M extends BaseTableMapper, B extends BaseModel> boolean delete(M mapper, B entity, String id) {
        entity.setId(id);
        entity.setModifyDate(new Date());
        entity.setRemove(1);
        if (mapper.update(entity) > 0) {
            return true;
        }
        return false;
    }

    protected <M extends BaseTableMapper, B extends BaseModel> boolean realDelete(M mapper, String id) {
        if (mapper.delete(id) > 0) {
            return true;
        }
        return false;
    }

    protected <M extends BaseTableMapper, B extends BaseModel> boolean update(M mapper, B entity) {
        entity.setModifyDate(new Date());
        if (mapper.update(entity) == 1) {
            return true;
        }
        return false;
    }

    //protected <M extends BaseTableMapper> T findById(M mapper, String id) {
    //    return (T) mapper.findById(id, null);
    //}
    //
    //protected <M extends BaseTableMapper> T findById(M mapper, String id, String userId) {
    //    return (T) mapper.findById(id, userId);
    //}
    //
    //protected <M extends BaseTableMapper> List<T> findByIds(M mapper, String[] ids) {
    //    return mapper.findByIds(ids, null);
    //}
    //
    //protected <M extends BaseTableMapper> List<T> findByIds(M mapper, String[] ids, String userId) {
    //    return mapper.findByIds(ids, userId);
    //}
    //
    //protected <M extends BaseTableMapper> List<T> findAll(M mapper) {
    //    return mapper.findAll(null);
    //}
    //
    //protected <M extends BaseTableMapper> List<T> findAll(M mapper, String userId) {
    //    return mapper.findAll(userId);
    //}
    //
    //protected <M extends BaseTableMapper> List<T> findByCondition(M mapper, Map<String, Object> condition) {
    //    return mapper.findByCondition(condition);
    //}

    protected <M extends BaseTableMapper> boolean checkDuplicate(M mapper, Map<String, Object> condition) {
        List result = mapper.findByCondition(condition);
        if (CollectionUtils.isEmpty(result)) {
            return true;
        }
        return false;
    }

}
