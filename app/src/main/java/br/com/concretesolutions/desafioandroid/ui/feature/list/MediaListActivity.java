package br.com.concretesolutions.desafioandroid.ui.feature.list;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.AMediaListBinding;
import br.com.concretesolutions.desafioandroid.ui.adapter.BaseAdapter;
import br.com.concretesolutions.desafioandroid.ui.base.BaseActivity;
import br.com.concretesolutions.desafioandroid.ui.decoration.CustomItemDecoration;
import br.com.concretesolutions.desafioandroid.viewmodel.MediaItemViewModel;


public class MediaListActivity extends BaseActivity {

    private static final String KEY_VIEW_MODEL_LIST = "KEY_VIEW_MODEL_LIST";
    private AMediaListBinding binding;
    private ArrayList<MediaItemViewModel> viewModelList;

    public static Intent intent(@NonNull final Context context, ArrayList<MediaItemViewModel> list) {
        Intent intent = new Intent(context, MediaListActivity.class);
        intent.putExtra(KEY_VIEW_MODEL_LIST, list);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.a_media_list);

        viewModelList = getIntent().getParcelableArrayListExtra(KEY_VIEW_MODEL_LIST);
        BaseAdapter<MediaItemViewModel> adapter = new BaseAdapter<>(R.layout.v_media_list_item);
        adapter.setList(viewModelList);
        binding.recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        int decorationSpace = getResources().getDimensionPixelOffset(R.dimen.smallest_margin);
        binding.recyclerView.addItemDecoration(new CustomItemDecoration(decorationSpace));
        binding.recyclerView.setAdapter(adapter);

    }
}
