package tw.com.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import tw.com.base.model.BaseNoPropertyModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 訂單與產品關聯
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderFormProduct extends BaseNoPropertyModel {
    /**
     * 訂單ID
     */
    @JsonIgnore
    private String orderFormId;
    /**
     * 產品ID
     */
    private String productId;
    /**
     * 產品數量
     */
    private Integer quantity;
    /**
     * 產品名稱
     */
    @XmlTransient
    private String productName;

    public OrderFormProduct() {
    }

    public OrderFormProduct(String orderFormId, String productId, Integer quantity, String productName) {

        this.orderFormId = orderFormId;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
    }

    public String getOrderFormId() {

        return orderFormId;
    }

    public void setOrderFormId(String orderFormId) {
        this.orderFormId = orderFormId;
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
        return "OrderFormProduct{" +
                "orderFormId='" + orderFormId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", productName='" + productName + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderFormProduct that = (OrderFormProduct) o;

        if (orderFormId != null ? !orderFormId.equals(that.orderFormId) : that.orderFormId != null) {
            return false;
        }
        return productId != null ? productId.equals(that.productId) : that.productId == null;

    }

    @Override
    public int hashCode() {
        int result = orderFormId != null ? orderFormId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }
}