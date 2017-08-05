package br.com.concretesolutions.desafioandroid.ui.feature.list;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.AMediaListBinding;
import br.com.concretesolutions.desafioandroid.manager.MediaManagerType;
import br.com.concretesolutions.desafioandroid.ui.adapter.PaginationAdapter;
import br.com.concretesolutions.desafioandroid.ui.base.BaseActivity;
import br.com.concretesolutions.desafioandroid.ui.decoration.CustomItemDecoration;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.disposables.CompositeDisposable;

import static br.com.concretesolutions.desafioandroid.manager.MediaManagerTypeHandler.getManagerObservable;
import static br.com.concretesolutions.desafioandroid.ui.feature.list.MediaStringHelper.getTextForMedia;


public class MediaListActivity extends BaseActivity {

    private static final String KEY_MEDIA_LIST = "KEY_MEDIA_LIST";
    private static final String KEY_MEDIA_TOTAL_PAGES = "KEY_MEDIA_TOTAL_PAGES";
    private static final String KEY_MANAGER_TYPE = "KEY_MANAGER_TYPE";
    private static final String KEY_CATEGORY = "KEY_CATEGORY";
    private AMediaListBinding binding;
    private List<Media> mediaList;
    private int totalPages;
    private CompositeDisposable subscriptions = new CompositeDisposable();
    private PaginationAdapter<Media> adapter;
    private @MediaManagerType int managerType;
    private int category;

    public static Intent intent(@NonNull final Context context, Page<Media> mediaPage, @MediaManagerType int managerType, int category) {
        Intent intent = new Intent(context, MediaListActivity.class);
        intent.putParcelableArrayListExtra(KEY_MEDIA_LIST, (ArrayList<? extends Parcelable>) mediaPage.results());
        intent.putExtra(KEY_MEDIA_TOTAL_PAGES, mediaPage.totalPages());
        intent.putExtra(KEY_MANAGER_TYPE, managerType);
        intent.putExtra(KEY_CATEGORY, category);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.a_media_list);
        mediaList = getIntent().getParcelableArrayListExtra(KEY_MEDIA_LIST);
        totalPages = getIntent().getIntExtra(KEY_MEDIA_TOTAL_PAGES, 1);
        //noinspection WrongConstant
        managerType = getIntent().getIntExtra(KEY_MANAGER_TYPE, MediaManagerType.MOVIE);
        category = getIntent().getIntExtra(KEY_CATEGORY, -1);


        setupToolbar();
        setupAdapter();
        setupRecyclerView();
    }

    private void setupToolbar() {
        String title = getTextForMedia(this, managerType, category);
        binding.toolbar.setTitle(title);
    }

    private void setupAdapter() {
        adapter = new PaginationAdapter<>(R.layout.v_media_list_item, page -> {
            try {
                subscriptions.add(getManagerObservable(managerType, category, page)
                        .subscribe(
                                MediaListActivity.this::onMediaSuccess,
                                MediaListActivity.this::onMediaError));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
        final Page<Media> mediaPage = new Page<>(mediaList, 1, totalPages);
        adapter.addPage(mediaPage);
    }

    private void onMediaSuccess(final Page<Media> mediaPage) {
        adapter.addPage(mediaPage);
    }

    private void onMediaError(Throwable throwable) {
        adapter.failPage();
        throwable.printStackTrace();
    }

    private void setupRecyclerView() {
        binding.recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        int decorationSpace = getResources().getDimensionPixelOffset(R.dimen.smallest_margin);
        binding.recyclerView.addItemDecoration(new CustomItemDecoration(decorationSpace));
        binding.recyclerView.setAdapter(adapter);
    }
}
