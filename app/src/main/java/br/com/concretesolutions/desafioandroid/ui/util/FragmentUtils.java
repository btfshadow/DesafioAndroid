package br.com.concretesolutions.desafioandroid.ui.util;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public final class FragmentUtils {

    private FragmentUtils() {
    }

    @Nullable
    public static <T extends Fragment> T findById(@NonNull FragmentActivity activity,
                                                  @IdRes int id) {
        //noinspection unchecked
        return (T) activity.getSupportFragmentManager().findFragmentById(id);
    }

    @Nullable
    public static <T extends Fragment> T findByTag(@NonNull FragmentActivity activity,
                                                   @NonNull String tag) {
        //noinspection unchecked
        return (T) activity.getSupportFragmentManager().findFragmentByTag(tag);
    }
}
