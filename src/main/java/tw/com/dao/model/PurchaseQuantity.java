package tw.com.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import tw.com.base.model.BaseNoPropertyModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 進貨單與產品關聯
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseQuantity extends BaseNoPropertyModel {
    /**
     * 進貨單ID
     */
    @JsonIgnore
    private String purchaseFormId;
    /**
     * 產品ID
     */
    @XmlElement(required = true)
    private String productId;
    /**
     * 進貨數量
     */
    @XmlElement(required = true)
    private Integer quantity;
    /**
     * 產品名稱
     */
    @XmlTransient
    private String productName;

    public PurchaseQuantity() {
    }

    public PurchaseQuantity(String purchaseFormId, String productId, Integer quantity, String productName) {

        this.purchaseFormId = purchaseFormId;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
    }

    public String getPurchaseFormId() {
        return purchaseFormId;
    }

    public void setPurchaseFormId(String purchaseFormId) {
        this.purchaseFormId = purchaseFormId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "PurchaseQuantity{" +
                "purchaseFormId='" + purchaseFormId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", productName='" + productName + '\'' +
                '}';
    }
}