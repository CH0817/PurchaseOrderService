package tw.com.web.service.impl;

import org.springframework.util.StringUtils;
import tw.com.dao.model.PurchaseForm;
import tw.com.dao.model.PurchaseQuantity;
import tw.com.service.PurchaseFormService;
import tw.com.utils.JsonUtils;
import tw.com.web.service.PurchaseFormWebService;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.List;

/**
 * Purchase form web service implement
 *
 * @author Rex
 */
@WebService
public class PurchaseFormWebServiceImpl implements PurchaseFormWebService {

    @Resource
    private PurchaseFormService purchaseFormService;

    @Override
    public String insert(PurchaseForm entity) {
        String id = null;
        try {
            id = purchaseFormService.insert(entity);
            if (!StringUtils.isEmpty(id)) {
                List<PurchaseQuantity> products = entity.getPurchaseQuantities();
                purchaseFormService.insert(products, id);
            }
            return JsonUtils.writeToJson(id);
        } catch (Exception e) {
            if (!StringUtils.isEmpty(id)) {
                purchaseFormService.realDelete(id);
            }
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String delete(String id) {
        try {
            return JsonUtils.writeToJson(purchaseFormService.delete(id));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String update(PurchaseForm entity) {
        try {
            return JsonUtils.writeToJson(purchaseFormService.update(entity));
        } catch (Exception e) {
            return JsonUtils.writeToJson(e);
        }
    }

    @Override
    public String findById(String id, String userId) {
        return JsonUtils.writeToJson(purchaseFormService.findById(id, userId));
    }

    @Override
    public String findByIds(String[] ids, String userId) {
        return JsonUtils.writeToJson(purchaseFormService.findByIds(ids, userId));
    }

    @Override
    public String findAll(String userId) {
        return JsonUtils.writeToJson(purchaseFormService.findAll(userId));
    }

}
