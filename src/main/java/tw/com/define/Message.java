package tw.com.define;

/**
 * 各種訊息宣告
 *
 * @author Rex
 */
public enum Message {

    TRANSFORM_JSON_FAIL("轉換JSON時發生錯誤"),
    NO_DATA("查無資料"),
    DO_NOT_SET_ID("新增時請勿自行設置id"),
    SUCCESS("成功"),
    FAIL("失敗");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
