package tw.com.dao.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 用戶與產品提供者關聯
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierUser {
    /**
     * 產品提供者ID
     */
    private String supplierId;
    /**
     * 用戶ID
     */
    private String userId;

    public SupplierUser() {
    }

    public SupplierUser(String supplierId, String userId) {

        this.supplierId = supplierId;
        this.userId = userId;
    }

    public void setSupplierId(String supplierId) {

        this.supplierId = supplierId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override

    public String toString() {
        return "SupplierUser{" +
                "supplierId='" + supplierId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}