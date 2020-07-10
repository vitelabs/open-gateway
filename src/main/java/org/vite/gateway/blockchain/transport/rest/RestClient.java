package org.vite.gateway.blockchain.transport.rest;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class RestClient {
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit retrofit;

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create());

    public static <T> T create(Class<T> serverClass, String baseUrl) {
        builder.baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient.build());
        retrofit = builder.build();

        return retrofit.create(serverClass);
    }

    public static <T> T executeSync( Call<T> call ) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println(response);
                throw new RestExcption("Server Error", response.code());
            }
        } catch (IOException e) {
            throw new RestExcption(e);
        }
    }
}
