package br.com.concretesolutions.desafioandroid.ui.feature.tv;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.FTvShowBinding;
import br.com.concretesolutions.desafioandroid.ui.base.BaseFragment;

public class TVShowFragment extends BaseFragment {

    public static TVShowFragment newInstance() {

        Bundle args = new Bundle();

        TVShowFragment fragment = new TVShowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private FTvShowBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.f_tv_show, container, false);
        return binding.getRoot();
    }
}
