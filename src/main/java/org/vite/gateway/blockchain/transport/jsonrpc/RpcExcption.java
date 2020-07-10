package org.vite.gateway.blockchain.transport.jsonrpc;

import com.alibaba.fastjson.JSONObject;

public class RpcExcption extends RuntimeException {
    private int code;
    private String message;
    private JSONObject data;


    public RpcExcption(Throwable cause) {
        super(cause);
    }

    public RpcExcption(int code, String message, JSONObject data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public JSONObject getData() {
        return data;
    }
}
