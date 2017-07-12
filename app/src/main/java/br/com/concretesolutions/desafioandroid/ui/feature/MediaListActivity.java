package br.com.concretesolutions.desafioandroid.ui.feature;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.AMediaListBinding;
import br.com.concretesolutions.desafioandroid.ui.base.BaseActivity;


public class MediaListActivity extends BaseActivity {

    private AMediaListBinding binding;

    public static Intent intent(@NonNull final Context context) {
        return new Intent(context, MediaListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.a_media_list);
    }
}
