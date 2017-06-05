package br.com.concretesolutions.repository.api.interceptors;

import java.io.IOException;

import br.com.concretesolutions.repository.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {

    private static final String API_KEY = "api_key";

    @Override
    public Response intercept(Chain chain) throws IOException {
        final HttpUrl url = chain.request().url()
                .newBuilder()
                .addQueryParameter(API_KEY, BuildConfig.API_KEY)
                .build();
        final Request request = chain.request().newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
