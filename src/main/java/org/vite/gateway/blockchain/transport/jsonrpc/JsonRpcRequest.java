package org.vite.gateway.blockchain.transport.jsonrpc;

import java.util.concurrent.atomic.AtomicLong;

public class JsonRpcRequest<T> {
    private static AtomicLong idGen = new AtomicLong(1);
    private String jsonrpc = "2.0";

    private String method;
    private T params;
    private long id;

    public JsonRpcRequest(){
        this.id = idGen.getAndAdd(1);
    }

    public JsonRpcRequest(String method){
        this.method = method;
        this.id = idGen.getAndAdd(1);
    }

    public JsonRpcRequest(String method,T params){
        this.method = method;
        this.params = params;
        this.id = idGen.getAndAdd(1);
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

