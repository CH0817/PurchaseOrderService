package tw.com.dao;

import tw.com.base.mapper.BaseMappingTableMapper;
import tw.com.dao.model.PurchaseQuantity;

import java.util.List;

public interface PurchaseQuantityMapper extends BaseMappingTableMapper<PurchaseQuantity> {
    void deleteByPurchaseForm(String purchaseFormId);

    List<PurchaseQuantity> findByPurchaseForm(String purchaseFormId);
}