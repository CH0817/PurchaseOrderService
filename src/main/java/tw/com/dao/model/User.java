package tw.com.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import tw.com.base.model.BaseModel;

import java.util.Date;

/**
 * 用戶
 *
 * @author Rex
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseModel {
    /**
     * 真實姓名
     */
    private String name;
    /**
     * 登入名
     */
    private String username;
    /**
     * 密碼
     */
    @JsonIgnore
    private String password;
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
     * 父用戶
     */
    private String parentId;

    public User() {
    }

    public User(String id, Date createDate, Date modifyDate, Integer remove, String name, String username,
                String password, String address, String email, String mobile, String parentId) {

        super(id, createDate, modifyDate, remove);
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.parentId = parentId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", parentId='" + parentId + '\'' +
                "} " + super.toString();
    }
}