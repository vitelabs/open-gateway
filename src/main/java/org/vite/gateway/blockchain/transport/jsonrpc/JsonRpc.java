package org.vite.gateway.blockchain.transport.jsonrpc;

public class JsonRpc<K, V> {
    private JsonRpcRequest<K> request;
    private JsonRpcResponse<V> response;


    public JsonRpc(JsonRpcRequest<K> request) {
        this.request = request;
    }

    public JsonRpcRequest<K> getRequest() {
        return request;
    }

    public void setRequest(JsonRpcRequest<K> request) {
        this.request = request;
    }

    public JsonRpcResponse<V> getResponse() {
        return response;
    }

    public void setResponse(JsonRpcResponse<V> response) {
        this.response = response;
    }
}
