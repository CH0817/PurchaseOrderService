package tw.com.json;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * JSON model
 *
 * @author Rex
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonModel {

    private Object value;
    private Boolean isSuccess;
    private String message;

    public JsonModel() {
    }

    public JsonModel(Boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public JsonModel(Object value, Boolean isSuccess, String message) {

        this.value = value;
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public Object getValue() {

        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JsonModel{" +
                "value=" + value +
                ", isSuccess=" + isSuccess +
                ", message='" + message + '\'' +
                '}';
    }
}
