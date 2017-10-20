package tw.com.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import tw.com.base.model.BaseModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 產品
 *
 * @author Rex
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModel {
    /**
     * 產品編號
     */
    private String productId;
    /**
     * 所屬用戶
     */
    @JsonIgnore
    private String userId;
    /**
     * 產品名稱
     */
    private String name;
    /**
     * 單價
     */
    private BigDecimal price;
    /**
     * 成本價
     */
    private BigDecimal cost;
    /**
     * 庫存
     */
    // FIXME: 2016/5/10 提供手動修改？
    //@XmlTransient
    private Integer reserve;

    public Product() {
    }

    public Product(String id, Date createDate, Date modifyDate, Integer remove, String productId, String userId,
                   String name, BigDecimal price, BigDecimal cost, Integer reserve) {

        super(id, createDate, modifyDate, remove);
        this.productId = productId;
        this.userId = userId;
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.reserve = reserve;
    }

    public String getProductId() {

        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                ", reserve=" + reserve +
                "} " + super.toString();
    }
}