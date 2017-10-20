package tw.com.base.web.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tw.com.define.Message;
import tw.com.json.JsonModel;

import java.util.Collection;

/**
 * 基本web service
 *
 * @author Rex
 */
public class BaseWebService {

    private ObjectMapper jsonUtil = new ObjectMapper();
    private JsonModel jsonModel;

    /**
     * 設置成功資訊
     *
     * @param value result
     */
    protected void setSuccess(Object value) {
        jsonModel = new JsonModel(value, true, Message.SUCCESS.getMessage());
    }

    /**
     * 設置失敗資訊
     */
    protected void setFail() {
        jsonModel = new JsonModel(false, Message.FAIL.getMessage());
    }

    /**
     * 設置失敗資訊，自定義message
     *
     * @param message 自訂訊息
     */
    protected void setFailByMessage(String message) {
        jsonModel = new JsonModel(false, message);
    }

    /**
     * 物件轉JSON字串
     *
     * @return JSON
     */
    protected String writeToJson() {
        String jsonStr = Message.TRANSFORM_JSON_FAIL.getMessage();
        try {
            jsonStr = jsonUtil.writeValueAsString(jsonModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * 檢查物件並回傳JSON字串
     *
     * @param data dao結果
     * @return JSON
     */
    protected String checkSuccess(Object data) {
        if (data != null) {
            setSuccess(data);
        } else {
            setFailByMessage(Message.NO_DATA.getMessage());
        }
        return writeToJson();
    }

    /**
     * 檢查集合並回傳JSON字串
     *
     * @param data dao結果
     * @return JSON
     */
    protected String checkSuccess(Collection data) {
        if (CollectionUtils.isEmpty(data)) {
            setFailByMessage(Message.NO_DATA.getMessage());
        } else {
            setSuccess(data);
        }
        return writeToJson();
    }

    /**
     * 檢查字串並回傳JSON物件
     *
     * @param id dao結果
     * @return JSON
     */
    protected String checkSuccess(String id) {
        if (StringUtils.isEmpty(id)) {
            setFail();
        } else {
            setSuccess(id);
        }
        return writeToJson();
    }

    /**
     * 檢查boolean並回傳JSON物件
     *
     * @param isSuccess dao結果
     * @return JSON
     */
    protected String checkSuccess(boolean isSuccess) {
        if (isSuccess) {
            setSuccess(null);
        } else {
            setFail();
        }
        return writeToJson();
    }

}
