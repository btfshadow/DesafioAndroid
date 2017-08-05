package br.com.concretesolutions.desafioandroid.ui.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.VMediaHorizontalItemBinding;
import br.com.concretesolutions.desafioandroid.ui.adapter.HorizontalListAdapter;
import br.com.concretesolutions.desafioandroid.ui.decoration.CustomItemDecoration;
import br.com.concretesolutions.desafioandroid.ui.feature.detail.MediaDetailActivity;
import br.com.concretesolutions.desafioandroid.ui.feature.list.MediaListActivity;
import br.com.concretesolutions.repository.model.MediaType;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

import static br.com.concretesolutions.desafioandroid.manager.MediaTypeManager.getMediaObservable;

public class MediaHorizontalListView extends FrameLayout implements HorizontalListAdapter.HorizontalListClickListener {

    private static final String STATE_ADAPTER = "STATE_ADAPTER_1";

    private VMediaHorizontalItemBinding binding;
    private HorizontalListAdapter adapter;
    private CompositeDisposable subscriptions = new CompositeDisposable();
    private Page<Media> mediaPage;

    public MediaHorizontalListView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MediaHorizontalListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(final Context context) {
        final LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = VMediaHorizontalItemBinding.inflate(inflater, this, true);
        setupAdapter();
        setupRecyclerView();
    }

    public void setObj(@Nullable MediaType obj) {
        if (obj == null)
            return;

        binding.setObj(obj);
        getMediaData(obj);
    }

    public void getMediaData(final MediaType mediaType) {
        loading(true);
        error(false);

        int firstPage = 1;
        final Observable<Page<Media>> observable;
        try {
            observable = getMediaObservable(mediaType, firstPage);
            subscriptions.add(observable.subscribe(this::onMediaSuccess, this::onMediaError));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void restoreInstanceState(final Bundle savedInstanceState) {
        if (savedInstanceState != null)
            adapter.restoreInstanceState(savedInstanceState.getBundle(STATE_ADAPTER));
    }

    public Bundle saveInstanceState(@NonNull final Bundle outState) {
        outState.putBundle(STATE_ADAPTER, adapter.saveInstanceState());
        return outState;
    }

    private void onMediaSuccess(final Page<Media> mediaPage) {
        loading(false);
        error(false);
        this.mediaPage = mediaPage;
        adapter.setList(mediaPage.results());
    }

    private void onMediaError(Throwable throwable) {
        loading(false);
        error(true);
        throwable.printStackTrace();
    }

    @Override
    public void onSeeMoreClick() {
        final MediaType obj = binding.getObj();
        final Intent intent = MediaListActivity.intent(getContext(), mediaPage, obj);
        getContext().startActivity(intent);
    }

    @Override
    public void onItemClick(@NonNull Media media) {
        getContext().startActivity(MediaDetailActivity.intent(getContext(), media));
    }

    private void setupAdapter() {
        adapter = new HorizontalListAdapter(this);
    }

    private void setupRecyclerView() {
        binding.recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        int decorationSpace = getContext().getResources().getDimensionPixelOffset(R.dimen.smallest_margin);
        binding.recyclerView.addItemDecoration(new CustomItemDecoration(decorationSpace));
        binding.recyclerView.setAdapter(adapter);
    }

    private void loading(boolean show) {
        changeVisibility(binding.loading, show);
    }

    private void error(boolean show) {
        changeVisibility(binding.txtErrorView, show);
        final MediaType obj = binding.getObj();
        binding.txtErrorView.setOnClickListener(v -> getMediaData(obj));
    }

    private void changeVisibility(final View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : GONE);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        subscriptions.clear();
    }
}
