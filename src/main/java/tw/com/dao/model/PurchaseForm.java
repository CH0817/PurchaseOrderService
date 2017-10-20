package tw.com.dao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import tw.com.base.model.BaseModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;

/**
 * 進貨單
 *
 * @author Rex
 */
// FIXME: 2016/5/10 是否需要加入狀態?
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseForm extends BaseModel {
    /**
     * 預計到達時間
     */
    @XmlElement(name = "estimatedTimeOfArrival", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date eta;
    /**
     * 實際到達時間
     */
    @XmlElement(name = "actualTimeOfArrival", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date ata;
    /**
     * 所屬用戶
     */
    @XmlElement(required = true)
    @JsonIgnore
    private String userId;
    /**
     * 產品ID及數量
     */
    @XmlElement(required = true)
    private List<PurchaseQuantity> purchaseQuantities;

    public PurchaseForm() {
    }

    public PurchaseForm(String id, Date createDate, Date modifyDate, Integer remove, Date eta, Date ata, String userId,
                        List<PurchaseQuantity> purchaseQuantities) {

        super(id, createDate, modifyDate, remove);
        this.eta = eta;
        this.ata = ata;
        this.userId = userId;
        this.purchaseQuantities = purchaseQuantities;
    }

    public Date getEta() {

        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public Date getAta() {
        return ata;
    }

    public void setAta(Date ata) {
        this.ata = ata;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<PurchaseQuantity> getPurchaseQuantities() {
        return purchaseQuantities;
    }

    public void setPurchaseQuantities(List<PurchaseQuantity> purchaseQuantities) {
        this.purchaseQuantities = purchaseQuantities;
    }

    @Override
    public String toString() {
        return "PurchaseForm{" +
                "eta=" + eta +
                ", ata=" + ata +
                ", userId='" + userId + '\'' +
                ", purchaseQuantities=" + purchaseQuantities +
                "} " + super.toString();
    }
}