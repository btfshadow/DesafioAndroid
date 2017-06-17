package br.com.concretesolutions.desafioandroid.ui.base.category;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.FBaseCategoryBinding;
import br.com.concretesolutions.desafioandroid.ui.adapter.BaseAdapter;
import br.com.concretesolutions.desafioandroid.ui.base.BaseFragment;
import br.com.concretesolutions.desafioandroid.viewmodel.MovieItemViewModel;

public class BaseCategoryFragment extends BaseFragment {

    private static final String STATE_ADAPTER = "STATE_ADAPTER";

    private FBaseCategoryBinding binding;
    protected BaseAdapter<MovieItemViewModel> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.f_base_category, container, false);

        setupAdapter(savedInstanceState);
        setupRecyclerView();

        return binding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBundle(STATE_ADAPTER, adapter.saveInstanceState());
        super.onSaveInstanceState(outState);
    }

    protected void setCategoryName(@StringRes int categoryName) {
        binding.txtCategoryName.setText(categoryName);
    }

    private void setupRecyclerView() {
        binding.recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerView.setAdapter(adapter);
    }

    private void setupAdapter(Bundle savedInstanceState) {
        adapter = new BaseAdapter<>(R.layout.v_movie_item);
        if (savedInstanceState != null)
            adapter.restoreInstanceState(savedInstanceState.getBundle(STATE_ADAPTER));
    }
}
