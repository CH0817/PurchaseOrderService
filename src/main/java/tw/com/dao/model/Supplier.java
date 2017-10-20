package tw.com.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import tw.com.base.model.BaseModel;

import java.util.Date;

/**
 * 產品提供者
 *
 * @author Rex
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Supplier extends BaseModel {
    /**
     * 姓名
     */
    private String name;
    /**
     * 地址
     */
    private String address;
    /**
     * Email
     */
    private String email;
    /**
     * 手機
     */
    private String mobile;
    /**
     * 所屬用戶
     */
    //FIXME: 2016/5/10 是否把所屬用戶移出? 會不會剛好有一個提供商對到兩個用戶?
    @JsonIgnore
    private String userId;

    public Supplier() {
    }

    public Supplier(String id, Date createDate, Date modifyDate, Integer remove, String name, String address,
                    String email, String mobile, String userId) {

        super(id, createDate, modifyDate, remove);
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.userId = userId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userId='" + userId + '\'' +
                "} " + super.toString();
    }
}