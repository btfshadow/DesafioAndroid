package br.com.concretesolutions.desafioandroid.ui.feature;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.FMediaBinding;
import br.com.concretesolutions.desafioandroid.ui.adapter.CategoryAdapter;
import br.com.concretesolutions.desafioandroid.ui.base.BaseFragment;
import br.com.concretesolutions.desafioandroid.viewmodel.CategoryViewModel;

public class MediaFragment extends BaseFragment {

    private static final String STATE_ADAPTER = "STATE_ADAPTER_0";
    private static final String VIEW_MODEL_LIST_KEY = "VIEW_MODEL_LIST_KEY";
    private FMediaBinding binding;
    private CategoryAdapter adapter;

    public static MediaFragment newInstance(@NonNull final ArrayList<CategoryViewModel> viewModelList) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(VIEW_MODEL_LIST_KEY, viewModelList);
        MediaFragment fragment = new MediaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.f_media, container, false);
        setupAdapter(savedInstanceState);
        setupRecyclerView();

        return binding.getRoot();
    }

    private void setupAdapter(Bundle savedInstanceState) {
        adapter = new CategoryAdapter();
        if (savedInstanceState != null)
            adapter.restoreInstanceState(savedInstanceState.getBundle(STATE_ADAPTER));
        final ArrayList<CategoryViewModel> viewModelList = getArguments().getParcelableArrayList(VIEW_MODEL_LIST_KEY);
        if (viewModelList != null)
            //noinspection unchecked
            adapter.setList(viewModelList);
    }

    private void setupRecyclerView() {
        binding.mediaRecyclerView.setHasFixedSize(true);
        binding.mediaRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.mediaRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBundle(STATE_ADAPTER, adapter.saveInstanceState());
        super.onSaveInstanceState(outState);
    }

}
