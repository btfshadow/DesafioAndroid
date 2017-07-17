package br.com.concretesolutions.desafioandroid.ui.feature.list;

import android.content.Context;
import android.support.annotation.NonNull;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.manager.MediaManagerType;
import br.com.concretesolutions.desafioandroid.manager.MoviesManager;
import br.com.concretesolutions.desafioandroid.manager.TVShowsManager;

public final class MediaStringHelper {

    public static String getTextForMedia(@NonNull final Context context, @MediaManagerType int type, int category) {
        String text;
        if (type == MediaManagerType.MOVIE) {
            text = getMovieCategoryText(context, category);
            text = text + " " + context.getString(R.string.movies).toLowerCase();
        } else {
            text = getTvShowsCategoryText(context, category);
            text = text + " " + context.getString(R.string.tv_shows).toLowerCase();
        }

        return text;
    }

    @NonNull
    private static String getTvShowsCategoryText(@NonNull Context context, int category) {
        String text;
        switch (category) {
            case TVShowsManager.TVCategoryType.POPULAR:
                text = context.getString(R.string.popular);
                break;
            case TVShowsManager.TVCategoryType.TOP_RATED:
                text = context.getString(R.string.top_rated);
                break;
            case TVShowsManager.TVCategoryType.AIRING_TODAY:
                text = context.getString(R.string.airing_today);
                break;
            case TVShowsManager.TVCategoryType.ON_THE_AIR:
                text = context.getString(R.string.on_the_air);
                break;
            default:
                text = context.getString(R.string.popular);
                break;
        }
        return text;
    }

    @NonNull
    private static String getMovieCategoryText(@NonNull Context context, int category) {
        String text;
        switch (category) {
            case MoviesManager.MovieCategoryType.POPULAR:
                text = context.getString(R.string.popular);
                break;
            case MoviesManager.MovieCategoryType.NOW_PLAYING:
                text = context.getString(R.string.now_playing);
                break;
            case MoviesManager.MovieCategoryType.TOP_RATED:
                text = context.getString(R.string.top_rated);
                break;
            case MoviesManager.MovieCategoryType.UP_COMING:
                text = context.getString(R.string.up_coming);
                break;
            default:
                text = context.getString(R.string.popular);
                break;
        }
        return text;
    }
}
