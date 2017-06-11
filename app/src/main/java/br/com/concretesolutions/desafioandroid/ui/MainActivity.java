package br.com.concretesolutions.desafioandroid.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.ActivityMainBinding;
import br.com.concretesolutions.desafioandroid.manager.MoviesManager;
import br.com.concretesolutions.desafioandroid.viewmodel.LatestMovieViewModel;
import br.com.concretesolutions.repository.model.Movie;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable subscriptions = new CompositeDisposable();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        subscriptions.add(MoviesManager.getLatest()
                .subscribe(this::onLatestSuccess, this::onLatestError));

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void onLatestError(final Throwable throwable) {
        throwable.printStackTrace();
    }

    private void onLatestSuccess(final Movie movie) {
        binding.moviesLatest.movie(new LatestMovieViewModel(movie));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscriptions.clear();
    }
}
