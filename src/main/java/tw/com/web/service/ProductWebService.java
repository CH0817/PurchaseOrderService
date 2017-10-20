package tw.com.web.service;

import tw.com.dao.model.Product;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Product web service interface
 *
 * @author Rex
 */
@WebService
public interface ProductWebService {
    /**
     * 新增
     *
     * @param entity 新增物件
     * @return JSON
     */
    @WebMethod()
    String insert(@WebParam(name = "entity") Product entity);

    /**
     * 刪除
     *
     * @param id 物件ID
     * @return JSON
     */
    @WebMethod
    String delete(@WebParam(name = "id") String id);

    /**
     * 更新
     *
     * @param entity 更新物件
     * @return JSON
     */
    @WebMethod
    String update(@WebParam(name = "entity") Product entity);

    /**
     * 依ID搜尋
     *
     * @param id 物件ID
     * @return JSON
     */
    @WebMethod
    String findById(@WebParam(name = "id") String id, @WebParam(name = "userId") String userId);

    /**
     * 依ID搜尋
     *
     * @param ids 物件ID
     * @return JSON
     */
    @WebMethod
    String findByIds(@WebParam(name = "ids") String[] ids, @WebParam(name = "userId") String userId);

    /**
     * 查詢全部
     *
     * @return JSON
     */
    @WebMethod
    String findAll(@WebParam(name = "userId") String userId);

    /**
     * 以產品提供者查詢產品
     *
     * @param supplierIds 產品提供者ID
     * @return JSON
     */
    @WebMethod
    String findBySupplier(@WebParam(name = "supplierIds") String[] supplierIds);

    /**
     * 檢查產品名稱是否重複
     *
     * @param name 產品名稱
     * @return JSON
     */
    @WebMethod
    String checkDuplicate(@WebParam(name = "productName") String name, @WebParam(name = "userId") String userId);

}
