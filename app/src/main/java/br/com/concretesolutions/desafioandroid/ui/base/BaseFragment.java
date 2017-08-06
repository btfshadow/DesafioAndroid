package br.com.concretesolutions.desafioandroid.ui.base;

import android.support.v4.app.Fragment;

import io.reactivex.disposables.CompositeDisposable;


public class BaseFragment extends Fragment {

    protected final CompositeDisposable subscriptions = new CompositeDisposable();

    @Override
    public void onDestroy() {
        super.onDestroy();
        subscriptions.clear();
    }

    public final void showLoading() {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).showLoading();
    }

    public final void hideLoading() {
        if (getActivity() != null)
            ((BaseActivity) getActivity()).hideLoading();
    }

}
