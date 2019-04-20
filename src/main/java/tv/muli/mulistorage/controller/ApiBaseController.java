package tv.muli.mulistorage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import tv.muli.mulistorage.constant.CodeMsgEnum;

/**
 * 接口控制器的基础类
 *
 * @author jory
 * @date 2019-03-14
 */
public class ApiBaseController {

    private static final String CODE = "code";

    private static final String MESSAGE = "message";

    private static final String DATA = "data";

    protected String successResult() {
        JSONObject result = new JSONObject();
        result.put(CODE, 0);
        result.put(MESSAGE, "success");
        return result.toJSONString();
    }

    protected String successResult(Object object) {
        JSONObject result = new JSONObject();
        result.put(CODE, 0);
        result.put(MESSAGE, "success");
        putResultData(result, object);
        return result.toJSONString();
    }

    protected String failResult() {
        JSONObject result = new JSONObject();
        result.put(CODE, 1);
        result.put(MESSAGE, "fail");
        return result.toJSONString();
    }

    protected String failResult(Object data) {
        JSONObject result = new JSONObject();
        result.put(CODE, 1);
        result.put(MESSAGE, "fail");
        putResultData(result, data);
        return result.toJSONString();
    }

    protected String failResult(CodeMsgEnum codeMsgEnum) {
        JSONObject result = new JSONObject();
        result.put(CODE, codeMsgEnum.getCode());
        result.put(MESSAGE, codeMsgEnum.getCode());
        return result.toJSONString();
    }

    protected String failResult(int code, String message) {
        JSONObject result = new JSONObject();
        result.put(CODE, code);
        result.put(MESSAGE, message);
        return result.toJSONString();
    }

    protected String failResult(CodeMsgEnum codeMsgEnum, Object data) {
        JSONObject result = new JSONObject();
        result.put(CODE, codeMsgEnum.getCode());
        result.put(MESSAGE, codeMsgEnum.getCode());
        putResultData(result, data);
        return result.toJSONString();
    }

    protected String failResult(int code, String message, Object data) {
        JSONObject result = new JSONObject();
        result.put(CODE, code);
        result.put(MESSAGE, message);
        putResultData(result, data);
        return result.toJSONString();
    }

    private void putResultData(JSONObject result, Object data) {
        if (data instanceof String) {
            result.put(DATA, data);
        } else {
            result.put(DATA, JSON.toJSON(data));
        }
    }
}
