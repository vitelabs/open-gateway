package org.vite.gateway.model.api;

import java.util.Objects;

public class APIResult<T> {

    public static int CODE_SUCCESS = 0;
    public static int CODE_ILLEGAL_PARAMETER = 1;
    public static int CODE_INTERNAL_ERROR = 2;

    public static int SUB_CODE_ILLEGAL = 00;
    public static int SUB_CODE_ILLEGAL_TOKENID = 10;
    public static int SUB_CODE_ILLEGAL_VITE_ADDRESS = 20;
    public static int SUB_CODE_ILLEGAL_AMOUNT_FORMAT = 30;

    private int code;
    private int subCode;
    private String msg;
    private T data;

    public static <T> APIResult<T> buildSuccess(T t) {
        APIResult<T> res = new APIResult<>();
        res.setCode(CODE_SUCCESS);
        res.setSubCode(CODE_SUCCESS);
        res.setData(t);

        return res;
    }

    public static <T> APIResult<T> buildIllegalParameter(int subCode, String msg) {
        APIResult<T> res = new APIResult<>();
        res.setCode(CODE_ILLEGAL_PARAMETER);
        res.setSubCode(subCode);
        res.setMsg(msg);
        return res;
    }

    public static <T> APIResult<T> buildInternalError(int subCode, String msg) {
        APIResult<T> res = new APIResult<>();
        res.setCode(CODE_INTERNAL_ERROR);
        res.setSubCode(subCode);
        res.setMsg(msg);
        return res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getSubCode() {
        return subCode;
    }

    public void setSubCode(int subCode) {
        this.subCode = subCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "APIResult{" +
                "code=" + code +
                ", subCode=" + subCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof APIResult)) return false;
        APIResult<?> res = (APIResult<?>)o;
        return code == res.code &&
                subCode == res.subCode &&
                Objects.equals(msg, res.msg) &&
                Objects.equals(data, res.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, subCode, msg, data);
    }
}
