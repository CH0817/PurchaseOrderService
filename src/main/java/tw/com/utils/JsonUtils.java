package tw.com.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tw.com.define.Message;
import tw.com.json.JsonModel;

import java.util.Collection;

/**
 * @author Rex
 */
public class JsonUtils {

    /**
     * 設置成功資訊
     *
     * @return JsonModel
     */
    public static JsonModel getNoDataSuccessJsonModel() {
        return new JsonModel(true, Message.SUCCESS.getMessage());
    }

    /**
     * 設置成功資訊
     *
     * @param value result
     * @return JsonModel
     */
    public static JsonModel getSuccessJsonModel(Object value) {
        return new JsonModel(value, true, Message.SUCCESS.getMessage());
    }

    /**
     * 設置失敗資訊
     *
     * @return JsonModel
     */
    public static JsonModel getFailJsonModel() {
        return new JsonModel(false, Message.FAIL.getMessage());
    }

    /**
     * 設置失敗資訊，自定義message
     *
     * @param message 自訂訊息
     * @return JsonModel
     */
    public static JsonModel setFailJsonMessageByMessage(String message) {
        return new JsonModel(false, message);
    }

    /**
     * 物件轉JSON字串
     *
     * @return JSON
     */
    public static String writeToJson(JsonModel jsonModel) {
        ObjectMapper jsonUtil = new ObjectMapper();
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
     * @return JsonModel
     */
    public static String writeToJson(Object data) {
        JsonModel jsonModel;
        if (data != null) {
            jsonModel = JsonUtils.getSuccessJsonModel(data);
        } else {
            jsonModel = JsonUtils.setFailJsonMessageByMessage(Message.NO_DATA.getMessage());
        }
        return writeToJson(jsonModel);
    }

    /**
     * 檢查集合並回傳JSON字串
     *
     * @param data dao結果
     * @return JsonModel
     */
    public static String writeToJson(Collection data) {
        JsonModel jsonModel;
        if (CollectionUtils.isEmpty(data)) {
            jsonModel = JsonUtils.setFailJsonMessageByMessage(Message.NO_DATA.getMessage());
        } else {
            jsonModel = JsonUtils.getSuccessJsonModel(data);
        }
        return writeToJson(jsonModel);
    }

    /**
     * 檢查字串並回傳JSON物件
     *
     * @param id dao結果
     * @return JsonModel
     */
    public static String writeToJson(String id) {
        JsonModel jsonModel;
        if (StringUtils.isEmpty(id)) {
            jsonModel = JsonUtils.getFailJsonModel();
        } else {
            jsonModel = JsonUtils.getSuccessJsonModel(id);
        }
        return writeToJson(jsonModel);
    }

    /**
     * 檢查boolean並回傳JSON物件
     *
     * @param isSuccess dao結果
     * @return JsonModel
     */
    public static String writeToJson(boolean isSuccess) {
        JsonModel jsonModel;
        if (isSuccess) {
            jsonModel = JsonUtils.getNoDataSuccessJsonModel();
        } else {
            jsonModel = JsonUtils.getFailJsonModel();
        }
        return writeToJson(jsonModel);
    }

    public static String writeToJson(Exception e) {
        return writeToJson(new JsonModel(false, e.getMessage()));
    }

}
