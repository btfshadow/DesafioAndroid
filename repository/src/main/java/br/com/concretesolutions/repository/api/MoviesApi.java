package br.com.concretesolutions.repository.api;

import android.support.annotation.NonNull;

import br.com.concretesolutions.repository.BuildConfig;
import br.com.concretesolutions.repository.api.interceptor.RequestInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

public class MoviesApi {

    private static MoviesService INSTANCE;

    public static MoviesService get() {
        if (INSTANCE == null) {
            INSTANCE = build();
        }
        return INSTANCE;
    }

    private static MoviesService build() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient())
                .build();

        return retrofit.create(MoviesService.class);
    }

    private static OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor())
                .addInterceptor(requestInterceptor())
                .build();
    }

    @NonNull
    private static RequestInterceptor requestInterceptor() {
        return new RequestInterceptor();
    }

    @NonNull
    private static HttpLoggingInterceptor loggingInterceptor() {
        return new HttpLoggingInterceptor(message -> Timber.i(message))
                .setLevel(BuildConfig.DEBUG ? BODY : NONE);
    }
}
