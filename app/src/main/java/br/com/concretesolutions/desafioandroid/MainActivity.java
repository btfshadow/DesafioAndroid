package br.com.concretesolutions.desafioandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import br.com.concretesolutions.desafioandroid.manager.MoviesManager;
import br.com.concretesolutions.repository.model.Movie;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable subscriptions = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subscriptions.add(MoviesManager.getLatest()
                .subscribe(this::onLatestSuccess, this::onLatestError));
    }

    private void onLatestError(Throwable throwable) {
        Log.e("TAG", "onLatestError: ");
    }

    private void onLatestSuccess(Movie movie) {
        Log.e("TAG", "onLatestSuccess: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscriptions.clear();
    }
}
