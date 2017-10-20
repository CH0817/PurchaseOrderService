package tw.com.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * 基礎model
 *
 * @author Rex
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseModel implements Serializable {
    /**
     * db id
     */
    private String id;

    /**
     * 建立時間
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createDate;

    /**
     * 修改時間
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
    private Date modifyDate;

    /**
     * 使用狀態
     */
    private Integer remove;

    public BaseModel() {
    }

    public BaseModel(String id, Date createDate, Date modifyDate, Integer remove) {

        this.id = id;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.remove = remove;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getRemove() {
        return remove;
    }

    public void setRemove(Integer remove) {
        this.remove = remove;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id='" + id + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", remove=" + remove +
                '}';
    }
}
