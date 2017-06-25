package br.com.concretesolutions.desafioandroid.ui.base.category;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.FBaseCategoryBinding;
import br.com.concretesolutions.desafioandroid.ui.adapter.BaseAdapter;
import br.com.concretesolutions.desafioandroid.ui.base.BaseFragment;
import br.com.concretesolutions.desafioandroid.viewmodel.MediaItemViewModel;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;

import static android.view.View.GONE;

public class BaseCategoryFragment<T extends Media> extends BaseFragment {

    private static final String STATE_ADAPTER = "STATE_ADAPTER";

    private FBaseCategoryBinding binding;
    protected BaseAdapter<MediaItemViewModel> adapter;

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

    public void onMediaSuccess(final Page<T> mediaPage) {
        loading(false);
        error(false);
        adapter.setList(getViewModelList(mediaPage));
    }

    public void onMediaError(Throwable throwable) {
        loading(false);
        error(true);
        throwable.printStackTrace();
    }

    protected void setCategoryName(@StringRes int categoryName) {
        binding.txtCategoryName.setText(categoryName);
    }

    protected List<MediaItemViewModel> getViewModelList(final Page<T> mediaPage) {
        List<MediaItemViewModel> viewModelList = new ArrayList<>();

        for (Media media : mediaPage.results())
            viewModelList.add(new MediaItemViewModel<>(media));

        return viewModelList;
    }

    private void loading(boolean show) {
        changeVisibility(binding.loading, show);
    }

    private void error(boolean show) {
        changeVisibility(binding.txtErrorView, show);
    }


    private void changeVisibility(final View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : GONE);
    }

    private void setupAdapter(Bundle savedInstanceState) {
        adapter = new BaseAdapter<>(R.layout.v_media_item);
        if (savedInstanceState != null)
            adapter.restoreInstanceState(savedInstanceState.getBundle(STATE_ADAPTER));
    }

    private void setupRecyclerView() {
        binding.recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerView.setAdapter(adapter);
    }
}
