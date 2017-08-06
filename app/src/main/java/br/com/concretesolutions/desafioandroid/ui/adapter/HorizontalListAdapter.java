package br.com.concretesolutions.desafioandroid.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.VMediaItemBinding;
import br.com.concretesolutions.desafioandroid.databinding.VSeeMoreBinding;
import br.com.concretesolutions.repository.model.Media;

public class HorizontalListAdapter extends BaseAdapter<Media> {

    public interface HorizontalListClickListener {
        void onSeeMoreClick();
        void onItemClick(@NonNull final Media media);
    }

    private static final int TYPE_SEE_MORE = 1;
    private HorizontalListClickListener clickListener;

    public HorizontalListAdapter(@NonNull final HorizontalListClickListener clickListener) {
        super(R.layout.v_media_item);
        this.clickListener = clickListener;
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
            binding.getRoot().setOnClickListener(v -> clickListener.onSeeMoreClick());
        } else {
            final VMediaItemBinding binding = (VMediaItemBinding) holder.binding;
            binding.getRoot().setOnClickListener(v -> clickListener.onItemClick(getItem(position)));
        }
    }
}
