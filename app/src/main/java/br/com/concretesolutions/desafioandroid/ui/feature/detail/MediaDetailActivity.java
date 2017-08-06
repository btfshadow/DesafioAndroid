package br.com.concretesolutions.desafioandroid.ui.feature.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.AMediaDetailBinding;
import br.com.concretesolutions.desafioandroid.ui.base.BaseActivity;
import br.com.concretesolutions.repository.model.Media;

public class MediaDetailActivity extends BaseActivity {

    public static final String EXTRA_POSTER = "EXTRA_POSTER";
    private static final String KEY_MEDIA_ITEM = "KEY_MEDIA_ITEM";
    private AMediaDetailBinding binding;

    public static Intent intent(@NonNull final Context context, Media item) {
        final Intent intent = new Intent(context, MediaDetailActivity.class);
        intent.putExtra(KEY_MEDIA_ITEM, item);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.a_media_detail);
        setStatusBarPadding(binding.appBarLayout);
        final Media item = getIntent().getParcelableExtra(KEY_MEDIA_ITEM);
        binding.setObj(item);
        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    protected void setStatusBarPadding(View view) {
        view.setPadding(view.getPaddingLeft(),
                view.getPaddingTop() + getStatusBarHeight(), view.getPaddingRight(),
                view.getPaddingBottom());
    }

    protected int getStatusBarHeight() {
        int result = 0;
        final int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) result = getResources().getDimensionPixelSize(resourceId);
        return result;
    }
}
