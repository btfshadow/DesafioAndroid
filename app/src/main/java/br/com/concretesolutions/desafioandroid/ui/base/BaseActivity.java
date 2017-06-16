package br.com.concretesolutions.desafioandroid.ui.base;

import android.support.v7.app.AppCompatActivity;

import br.com.concretesolutions.desafioandroid.ui.dialog.LoadingFragment;
import io.reactivex.disposables.CompositeDisposable;

public class BaseActivity extends AppCompatActivity {

    protected final CompositeDisposable subscriptions = new CompositeDisposable();
    private LoadingFragment loadingFragment;

    @Override
    public void onDestroy() {
        super.onDestroy();
        subscriptions.clear();
    }

    public final void showLoading() {
        loadingFragment = LoadingFragment.show(this, loadingFragment);
    }

    public final void hideLoading() {
        loadingFragment = LoadingFragment.hide(loadingFragment);
    }
}
