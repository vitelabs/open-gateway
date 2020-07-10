package org.vite.gateway.blockchain.transport.jsonrpc;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JsonRpcClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonRpcClient.class);
    private OkHttpClient httpClient;
    private String url;

    public JsonRpcClient(String url, String username, String password) {
        this.url = url;
        this.httpClient = createAuthenticatedClient(username, password);
    }

    public JSONObject call(String method) throws IOException {
        return call(new JsonRpcRequest(method, null));
    }

    public JSONObject call(String method, List<Object> args) throws IOException {
        return call(new JsonRpcRequest(method, args));
    }

    public JSONObject call(JsonRpcRequest rpcRequest) throws IOException {
        Response response = sendRequest(JSONObject.toJSONString(rpcRequest, SerializerFeature.WriteMapNullValue));

        int code = response.code();
        String message = response.message();

        String body = response.body().string();
        LOGGER.debug("response {} {} {} {}", url, code, message, body);

        JSONObject object = JSONObject.parseObject(body);

        if (code != 200) {
            throw new RpcExcption(code, message, object);
        }

        return object;
    }

    private Response sendRequest(String content) throws IOException {
        LOGGER.debug("request {} {}", url, content);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), content);
        Request request = new Request.Builder()
                .addHeader("cache-control", "no-cache")
                .addHeader("Accept-Encoding", "identity")
                .addHeader("Accept", "*/*")
                .addHeader("content-type", "application/json")
                .url(url).post(body).build();

        Call call = httpClient
                .newBuilder()
                .callTimeout(2, TimeUnit.SECONDS)
                .build()
                .newCall(request);

        Response response = call.execute();

        return response;
    }

    private static OkHttpClient createAuthenticatedClient(final String username,
                                                          final String password) {
        // build client with authentication information.
        OkHttpClient httpClient = new OkHttpClient.Builder().authenticator((route, response) -> {
            String credential = Credentials.basic(username, password);
            return response
                    .request()
                    .newBuilder()
                    .header("Authorization", credential)
                    .build();
        }).build();
        return httpClient;
    }
}
