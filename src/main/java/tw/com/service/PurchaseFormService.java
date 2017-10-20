package tw.com.service;

import tw.com.base.service.BaseService;
import tw.com.dao.model.PurchaseForm;
import tw.com.dao.model.PurchaseQuantity;

import java.util.List;

/**
 * Purchase form service
 *
 * @author Rex
 */
public interface PurchaseFormService extends BaseService<PurchaseForm> {
    void insert(List<PurchaseQuantity> entities, String purchaseFromId);

    boolean realDelete(String id);
}
