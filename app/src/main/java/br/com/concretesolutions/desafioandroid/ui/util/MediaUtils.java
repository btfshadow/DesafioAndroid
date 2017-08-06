package br.com.concretesolutions.desafioandroid.ui.util;

import android.content.Context;
import android.text.TextUtils;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.repository.BuildConfig;
import br.com.concretesolutions.repository.model.Media;

public final class MediaUtils {

    private MediaUtils() {
    }

    public static String getPosterUrl(final Media media) {
        return BuildConfig.BASE_IMAGE_URL + media.poster();
    }

    public static String getBackdropUrl(final Media media) {
        return BuildConfig.BASE_IMAGE_URL + media.backdrop();
    }

    public static float getRatingValue(final Media media) {
        float currentRate = Float.valueOf(media.rating());

        float newRate = (((currentRate * 1) / 10) * 5 ) / 1;
        return newRate;
    }

    public static String getRatingText(final Context context, final Media media) {
        if (TextUtils.isEmpty(media.rating()))
            return context.getString(R.string.media_item_no_rating);
        return context.getString(R.string.media_item_rating, media.rating());
    }
}
