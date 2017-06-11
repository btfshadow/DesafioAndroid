package br.com.concretesolutions.repository.api;

import android.support.annotation.NonNull;

import br.com.concretesolutions.repository.BuildConfig;
import br.com.concretesolutions.repository.api.interceptor.RequestInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class MoviesApi {

    static MoviesService INSTANCE;

    public static MoviesService get() {
        if (INSTANCE == null) {
            INSTANCE = build();
        }
        return INSTANCE;
    }

    private static MoviesService build() {
        return new ApiBuilder<MoviesService>()
                .baseUrl(BuildConfig.BASE_URL)
                .converterFactory(GsonConverterFactory.create())
                .okHttpClient(okHttpClient())
                .service(MoviesService.class)
                .build();
    }

    public static OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor())
                .addInterceptor(loggingInterceptor())
                .build();
    }

    @NonNull
    private static RequestInterceptor requestInterceptor() {
        return new RequestInterceptor();
    }

    @NonNull
    private static HttpLoggingInterceptor loggingInterceptor() {
        return new HttpLoggingInterceptor(message -> Timber.i(message))
                .setLevel(BODY);
    }
}
