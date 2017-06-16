package br.com.concretesolutions.desafioandroid.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.ActivityMainBinding;
import br.com.concretesolutions.desafioandroid.manager.MoviesManager;
import br.com.concretesolutions.desafioandroid.viewmodel.MovieItemViewModel;
import br.com.concretesolutions.repository.model.Movie;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable subscriptions = new CompositeDisposable();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        subscriptions.add(MoviesManager.getPopular()
                .subscribe(this::onLatestSuccess, this::onLatestError));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscriptions.clear();
    }

    private void onLatestError(final Throwable throwable) {
        throwable.printStackTrace();
    }

    private void onLatestSuccess(final Page<Movie> movie) {
        binding.movieItemViewTest.movie(new MovieItemViewModel(movie.results().get(0)));
    }
}
