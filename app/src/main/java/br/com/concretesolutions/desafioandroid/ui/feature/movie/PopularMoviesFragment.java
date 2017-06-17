package br.com.concretesolutions.desafioandroid.ui.feature.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.manager.MoviesManager;
import br.com.concretesolutions.desafioandroid.ui.base.category.BaseCategoryFragment;
import br.com.concretesolutions.desafioandroid.viewmodel.MovieItemViewModel;
import br.com.concretesolutions.repository.model.Movie;
import br.com.concretesolutions.repository.model.Page;

public class PopularMoviesFragment extends BaseCategoryFragment {

    public static PopularMoviesFragment newInstance() {

        Bundle args = new Bundle();

        PopularMoviesFragment fragment = new PopularMoviesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        setCategoryName(R.string.popular);

        subscriptions.add(MoviesManager
                .getPopular()
                .subscribe(this::onMoviesSuccess, this::onMoviesError));

        return view;
    }

    private void onMoviesSuccess(Page<Movie> moviePage) {
        List<MovieItemViewModel> viewModelList = new ArrayList<>();

        for (Movie movie : moviePage.results())
            viewModelList.add(new MovieItemViewModel(movie));
        adapter.setList(viewModelList);
    }

    private void onMoviesError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
