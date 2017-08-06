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
import br.com.concretesolutions.desafioandroid.ui.adapter.PaginationAdapter;
import br.com.concretesolutions.desafioandroid.ui.base.BaseActivity;
import br.com.concretesolutions.desafioandroid.ui.decoration.CustomItemDecoration;
import br.com.concretesolutions.repository.model.MediaType;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.disposables.CompositeDisposable;

import static br.com.concretesolutions.desafioandroid.manager.MediaTypeManager.getMediaObservable;
import static br.com.concretesolutions.desafioandroid.ui.feature.list.MediaStringHelper.getTextForMedia;


public class MediaListActivity extends BaseActivity {

    private static final String KEY_MEDIA_LIST = "KEY_MEDIA_LIST";
    private static final String KEY_MEDIA_TOTAL_PAGES = "KEY_MEDIA_TOTAL_PAGES";
    private static final String KEY_MEDIA_TYPE = "KEY_MEDIA_TYPE";
    private AMediaListBinding binding;
    private CompositeDisposable subscriptions = new CompositeDisposable();
    private PaginationAdapter<Media> adapter;

    public static Intent intent(@NonNull final Context context, Page<Media> mediaPage, final MediaType mediaType) {
        Intent intent = new Intent(context, MediaListActivity.class);
        intent.putParcelableArrayListExtra(KEY_MEDIA_LIST, (ArrayList<? extends Parcelable>) mediaPage.results());
        intent.putExtra(KEY_MEDIA_TOTAL_PAGES, mediaPage.totalPages());
        intent.putExtra(KEY_MEDIA_TYPE, mediaType);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.a_media_list);
        final MediaType mediaType = getIntent().getParcelableExtra(KEY_MEDIA_TYPE);
        setupToolbar(mediaType);
        setupAdapter(mediaType);
        setupRecyclerView();
    }

    private void setupToolbar(final MediaType mediaType) {
        String title = getTextForMedia(this, mediaType);
        binding.toolbar.setTitle(title);
        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void setupAdapter(final MediaType mediaType) {
        adapter = new PaginationAdapter<>(R.layout.v_media_list_item, page -> {
            try {
                subscriptions.add(getMediaObservable(mediaType, page)
                        .subscribe(
                                MediaListActivity.this::onMediaSuccess,
                                MediaListActivity.this::onMediaError));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        });

        final List<Media> mediaList = getIntent().getParcelableArrayListExtra(KEY_MEDIA_LIST);
        int totalPages = getIntent().getIntExtra(KEY_MEDIA_TOTAL_PAGES, 1);

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
