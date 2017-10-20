package tw.com.dao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import tw.com.base.model.BaseModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.List;

/**
 * 訂單
 *
 * @author Rex
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderForm extends BaseModel {
    /**
     * 訂單編號
     */
    private String orderFormId;
    /**
     * 所屬用戶
     */
    @JsonIgnore
    private String userId;
    /**
     * 所屬客戶
     */
    private String customerId;
    /**
     * 客戶姓名
     */
    @XmlTransient
    private String customerName;
    /**
     * 預計到達時間
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date targetShipDate;
    /**
     * 實際到達時間
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date actualShipDate;
    /**
     * 訂單狀態
     */
    private Integer status;
    /**
     * 產品編號及數量
     */
    private List<OrderFormProduct> products;

    public OrderForm() {
    }

    public OrderForm(String id, Date createDate, Date modifyDate, Integer remove, String orderFormId, String userId,
                     String customerId, String customerName, Date targetShipDate, Date actualShipDate, Integer status,
                     List<OrderFormProduct> products) {

        super(id, createDate, modifyDate, remove);
        this.orderFormId = orderFormId;
        this.userId = userId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.targetShipDate = targetShipDate;
        this.actualShipDate = actualShipDate;
        this.status = status;
        this.products = products;
    }

    public String getOrderFormId() {

        return orderFormId;
    }

    public void setOrderFormId(String orderFormId) {
        this.orderFormId = orderFormId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getTargetShipDate() {
        return targetShipDate;
    }

    public void setTargetShipDate(Date targetShipDate) {
        this.targetShipDate = targetShipDate;
    }

    public Date getActualShipDate() {
        return actualShipDate;
    }

    public void setActualShipDate(Date actualShipDate) {
        this.actualShipDate = actualShipDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<OrderFormProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderFormProduct> products) {
        this.products = products;
    }

    /**
     * 要被轉換成JSON的產品編號及數量
     */
    @Override
    public String toString() {
        return "OrderForm{" +
                "orderFormId='" + orderFormId + '\'' +
                ", userId='" + userId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", targetShipDate=" + targetShipDate +
                ", actualShipDate=" + actualShipDate +
                ", status=" + status +
                ", products=" + products +
                "} " + super.toString();
    }
}