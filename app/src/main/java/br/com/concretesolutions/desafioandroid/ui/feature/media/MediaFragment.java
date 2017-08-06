package br.com.concretesolutions.desafioandroid.ui.feature.media;

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
import br.com.concretesolutions.desafioandroid.ui.adapter.BaseAdapter;
import br.com.concretesolutions.desafioandroid.ui.base.BaseFragment;
import br.com.concretesolutions.repository.model.MediaType;

public class MediaFragment extends BaseFragment {

    private static final String STATE_ADAPTER = "STATE_ADAPTER_0";
    private static final String MEDIA_TYPE_LIST = "MEDIA_TYPE_LIST";
    private FMediaBinding binding;
    private BaseAdapter<MediaType> adapter;

    public static MediaFragment newInstance(@NonNull final ArrayList<MediaType> mediaTypeList) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(MEDIA_TYPE_LIST, mediaTypeList);
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
        adapter = new BaseAdapter<>(R.layout.v_category_item);
        if (savedInstanceState != null)
            adapter.restoreInstanceState(savedInstanceState.getBundle(STATE_ADAPTER));
        final ArrayList<MediaType> mediaTypeList = getArguments().getParcelableArrayList(MEDIA_TYPE_LIST);
        if (mediaTypeList != null)
            //noinspection unchecked
            adapter.setList(mediaTypeList);
    }

    private void setupRecyclerView() {
        binding.mediaRecyclerView.setHasFixedSize(true);
        binding.mediaRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.mediaRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (adapter != null)
            outState.putBundle(STATE_ADAPTER, adapter.saveInstanceState());
        super.onSaveInstanceState(outState);
    }

}
