package br.com.concretesolutions.desafioandroid.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.ViewGroup;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.VSeeMoreBinding;
import br.com.concretesolutions.desafioandroid.ui.feature.MediaListActivity;
import br.com.concretesolutions.desafioandroid.viewmodel.MediaItemViewModel;

public class HorizontalListAdapter extends BaseAdapter<MediaItemViewModel> {

    private static final int TYPE_SEE_MORE = 1;

    public HorizontalListAdapter() {
        super(R.layout.v_media_item);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 19)
            return TYPE_SEE_MORE;
        else
            return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_SEE_MORE)
            return new ViewHolder(DataBindingUtil.inflate(getLayoutInflater(parent), R.layout.v_see_more, parent, false));
        else
            return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_SEE_MORE) {
            final VSeeMoreBinding binding = (VSeeMoreBinding) holder.binding;
            binding.getRoot().setOnClickListener(v -> {
                        Context context = binding.getRoot().getContext();
                        context.startActivity(MediaListActivity.intent(context));
                    }
            );
        } else

            super.onBindViewHolder(holder, position);
    }
}
