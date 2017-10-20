package tw.com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.com.base.service.impl.BaseServiceImpl;
import tw.com.dao.model.PurchaseForm;
import tw.com.dao.model.PurchaseQuantity;
import tw.com.service.PurchaseFormService;

import java.util.List;
import java.util.Map;

/**
 * Purchase form service implement
 *
 * @author Rex
 */
@Transactional
@Service
public class PurchaseFormServiceImpl extends BaseServiceImpl<PurchaseForm> implements PurchaseFormService {
    @Override
    public String insert(PurchaseForm entity) {
        return super.insert(purchaseFormMapper, entity);
    }

    @Override
    public void insert(List<PurchaseQuantity> entities, String purchaseFromId) {
        entities.stream().forEach(purchaseFormProduct -> {
            purchaseFormProduct.setPurchaseFormId(purchaseFromId);
            super.insert(purchaseQuantityMapper, purchaseFormProduct);
        });
    }

    @Override
    public boolean delete(String id) {
        return super.delete(purchaseFormMapper, new PurchaseForm(), id);
    }

    @Override
    public boolean realDelete(String id) {
        return super.realDelete(purchaseFormMapper, id);
    }

    @Override
    public boolean update(PurchaseForm entity) {
        //先delete全部PurchaseQuantity再insert
        purchaseQuantityMapper.deleteByPurchaseForm(entity.getId());
        this.insert(entity.getPurchaseQuantities(), entity.getId());
        return super.update(purchaseFormMapper, entity);
    }

    @Override
    public PurchaseForm findById(String id, String userId) {
        PurchaseForm purchaseForm = purchaseFormMapper.findById(id, userId);
        purchaseForm.setPurchaseQuantities(purchaseQuantityMapper.findByPurchaseForm(purchaseForm.getId()));
        return purchaseForm;
    }

    @Override
    public List<PurchaseForm> findByIds(String[] ids, String userId) {
        List<PurchaseForm> purchaseForms = purchaseFormMapper.findByIds(ids, userId);
        setQuantity(purchaseForms);
        return purchaseForms;
    }

    @Override
    public List<PurchaseForm> findAll(String userId) {
        List<PurchaseForm> purchaseForms = purchaseFormMapper.findAll(userId);
        setQuantity(purchaseForms);
        return purchaseForms;
    }

    @Override
    public List<PurchaseForm> findByCondition(Map<String, Object> condition) {
        return purchaseFormMapper.findByCondition(condition);
    }

    private void setQuantity(List<PurchaseForm> purchaseForms) {
        purchaseForms.stream().forEach(purchaseForm -> purchaseForm
                .setPurchaseQuantities(purchaseQuantityMapper.findByPurchaseForm(purchaseForm.getId())));
    }

}
