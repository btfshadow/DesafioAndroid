package br.com.concretesolutions.desafioandroid.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.ui.base.BaseActivity;


public class LoadingFragment extends DialogFragment {

    private static final String LOADING_FRAGMENT = "loadingFragment";

    public static LoadingFragment show(final BaseActivity activity, LoadingFragment fragmentInstance) {
        if (fragmentInstance == null) {
            fragmentInstance = new LoadingFragment();
            fragmentInstance.setCancelable(false);
        }

        if (!fragmentInstance.isVisible()) {
            fragmentInstance.show(activity.getSupportFragmentManager(), LOADING_FRAGMENT);
        }

        return fragmentInstance;
    }

    public static LoadingFragment hide(LoadingFragment fragmentInstance) {
        if (fragmentInstance != null) {
            fragmentInstance.dismiss();
        }
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.LoadingFragment);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_loading, container, false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}
