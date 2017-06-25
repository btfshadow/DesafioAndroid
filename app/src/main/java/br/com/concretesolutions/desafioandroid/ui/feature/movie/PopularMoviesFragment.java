package br.com.concretesolutions.desafioandroid.ui.feature.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.manager.MoviesManager;
import br.com.concretesolutions.desafioandroid.ui.base.category.BaseCategoryFragment;
import br.com.concretesolutions.repository.model.Movie;

public class PopularMoviesFragment extends BaseCategoryFragment<Movie> {

    public static PopularMoviesFragment newInstance() {
        return new PopularMoviesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        setCategoryName(R.string.popular);
        subscriptions.add(MoviesManager
                .getPopular()
                .subscribe(super::onMediaSuccess, super::onMediaError));
        return view;
    }
}
