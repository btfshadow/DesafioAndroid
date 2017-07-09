package br.com.concretesolutions.repository.api;

import android.support.annotation.NonNull;

import br.com.concretesolutions.repository.BuildConfig;
import br.com.concretesolutions.repository.api.interceptor.RequestInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class MediaApi {

    public static MediaService INSTANCE;

    public static MediaService get() {
        if (INSTANCE == null) {
            INSTANCE = build();
        }
        return INSTANCE;
    }

    private static MediaService build() {
        return new ApiBuilder<MediaService>()
                .baseUrl(BuildConfig.BASE_URL)
                .converterFactory(GsonConverterFactory.create())
                .okHttpClient(okHttpClient())
                .service(MediaService.class)
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
