package br.com.concretesolutions.desafioandroid.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.VMediaHorizontalItemBinding;
import br.com.concretesolutions.desafioandroid.manager.MediaManagerType;
import br.com.concretesolutions.desafioandroid.manager.MoviesManager;
import br.com.concretesolutions.desafioandroid.manager.TVShowsManager;
import br.com.concretesolutions.desafioandroid.ui.adapter.BaseAdapter;
import br.com.concretesolutions.desafioandroid.ui.decoration.CustomItemDecoration;
import br.com.concretesolutions.desafioandroid.viewmodel.MediaItemViewModel;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class MediaHorizontalListView extends FrameLayout {

    private static final String STATE_ADAPTER = "STATE_ADAPTER_1";

    private VMediaHorizontalItemBinding binding;
    private BaseAdapter<MediaItemViewModel> adapter;
    private CompositeDisposable subscriptions = new CompositeDisposable();
    @MediaManagerType
    private int mediaManager;

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

    public void setManagerType(@MediaManagerType int mediaManager) {
        this.mediaManager = mediaManager;
    }

    public void getMedia(@MoviesManager.MovieCategoryType int category) throws NoSuchMethodException {
        loading(true);
        error(false);

        Observable<Page<Media>> observable;
        if (mediaManager == MediaManagerType.MOVIE)
            observable = MoviesManager.get(category);
        else
            observable = TVShowsManager.get(category);
            subscriptions.add(observable.subscribe(this::onMediaSuccess, this::onMediaError));
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
        adapter.setList(getViewModelList(mediaPage));
    }

    private void onMediaError(Throwable throwable) {
        loading(false);
        error(true);
        throwable.printStackTrace();
    }

    private void setupAdapter() {
        adapter = new BaseAdapter<>(R.layout.v_media_item);
    }

    private void setupRecyclerView() {
        binding.recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        int decorationSpace= getContext().getResources().getDimensionPixelOffset(R.dimen.dimen_4dp);
        binding.recyclerView.addItemDecoration(new CustomItemDecoration(decorationSpace));
        binding.recyclerView.setAdapter(adapter);
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

    private List<MediaItemViewModel> getViewModelList(final Page<Media> mediaPage) {
        List<MediaItemViewModel> viewModelList = new ArrayList<>();

        for (Media media : mediaPage.results())
            viewModelList.add(new MediaItemViewModel(media));

        return viewModelList;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        subscriptions.clear();
    }
}
