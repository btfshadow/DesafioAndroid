package br.com.concretesolutions.desafioandroid.ui.feature.movie;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.FMovieBinding;
import br.com.concretesolutions.desafioandroid.ui.base.BaseFragment;

public class MovieFragment extends BaseFragment {

    private FMovieBinding binding;

    public static MovieFragment newInstance() {

        Bundle args = new Bundle();

        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.f_movie, container, false);
        return binding.getRoot();
    }
}
