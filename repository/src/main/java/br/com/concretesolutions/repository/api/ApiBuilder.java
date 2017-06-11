package br.com.concretesolutions.repository.api;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder<T> {
    private OkHttpClient okHttpClient;
    private String baseUrl;
    private GsonConverterFactory converterFactory;
    private Class<T> service;

    public ApiBuilder<T> okHttpClient(@NonNull final OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
        return this;
    }

    public ApiBuilder<T> baseUrl(@NonNull final String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public ApiBuilder<T> converterFactory(@NonNull final GsonConverterFactory converterFactory) {
        this.converterFactory = converterFactory;
        return this;
    }

    public ApiBuilder<T> service(@NonNull final Class<T> service) {
        this.service = service;
        return this;
    }

    public T build() {
        if (okHttpClient == null) throw new IllegalStateException("OkHttpClient null");
        if (baseUrl == null) throw new IllegalStateException("BaseUrl null");
        if (converterFactory == null) throw new IllegalStateException("ConverterFactory null");
        if (service == null) throw new IllegalStateException("Service null");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .build();

        return retrofit.create(service);
    }
}
