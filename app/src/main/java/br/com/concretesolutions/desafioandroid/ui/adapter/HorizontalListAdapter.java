package br.com.concretesolutions.desafioandroid.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.ViewGroup;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.VMediaItemBinding;
import br.com.concretesolutions.desafioandroid.databinding.VSeeMoreBinding;
import br.com.concretesolutions.desafioandroid.ui.feature.detail.MediaDetailActivity;
import br.com.concretesolutions.desafioandroid.ui.feature.list.MediaListActivity;
import br.com.concretesolutions.desafioandroid.viewmodel.CategoryViewModel;
import br.com.concretesolutions.desafioandroid.viewmodel.MediaItemViewModel;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;

public class HorizontalListAdapter extends BaseAdapter<MediaItemViewModel> {

    private static final int TYPE_SEE_MORE = 1;
    private CategoryViewModel categoryViewModel;
    private Page<Media> mediaPage;

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
        super.onBindViewHolder(holder, position);
        if (getItemViewType(position) == TYPE_SEE_MORE) {
            final VSeeMoreBinding binding = (VSeeMoreBinding) holder.binding;
            binding.getRoot().setOnClickListener(v -> startMediaListActivity(binding));
        } else {
            final VMediaItemBinding binding = (VMediaItemBinding) holder.binding;
            binding.getRoot().setOnClickListener(v -> startMediaDetailsActivity(position, binding));
        }
    }

    private void startMediaDetailsActivity(int position, VMediaItemBinding binding) {
        final Context context = binding.getRoot().getContext();
        context.startActivity(MediaDetailActivity.intent(context, getItem(position)));
    }

    private void startMediaListActivity(VSeeMoreBinding binding) {
        final Context context = binding.getRoot().getContext();
        final Intent intent = MediaListActivity.intent(context, mediaPage, categoryViewModel.getManagerType(), categoryViewModel.getCategoryName());
        context.startActivity(intent);
    }

    public void setCategoryViewModel(CategoryViewModel categoryViewModel) {
        this.categoryViewModel = categoryViewModel;
    }

    public void setMediaPage(Page<Media> mediaPage) {
        this.mediaPage = mediaPage;
    }
}
