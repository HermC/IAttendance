package edu.nju.ise.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 用来包装请求返回值数据的类
 *
 * @author Hermit
 * @version 1.0 2018/02/13
 * */
public class ResponseData {

    private  int code;
    private  String message;
    private  Object data;

    public ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseData(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseData ok(Object data) {
        ResponseData responseData = new ResponseData(200, "Ok", data);
        return responseData;
    }

    public static ResponseData notFound() {
        return new ResponseData(404, "Not Found");
    }

    public static ResponseData badRequest() {
        return new ResponseData(400, "Bad Request");
    }

    public static ResponseData badRequest(String message) {
        return new ResponseData(400, message);
    }

    public static ResponseData forbidden() {
        return new ResponseData(403, "Forbidden");
    }

    public static ResponseData unauthorized() {
        return new ResponseData(401, "unauthorized");
    }

    public static ResponseData internalServerError() {
        return new ResponseData(500, "Internal Server Error");
    }

}
