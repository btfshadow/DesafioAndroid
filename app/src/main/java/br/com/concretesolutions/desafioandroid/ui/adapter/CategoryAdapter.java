package br.com.concretesolutions.desafioandroid.ui.adapter;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.VCategoryItemBinding;
import br.com.concretesolutions.desafioandroid.viewmodel.CategoryViewModel;

public class CategoryAdapter extends BaseAdapter {

    public CategoryAdapter() {
        super(R.layout.v_category_item);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        final CategoryViewModel viewModel = (CategoryViewModel) getItem(position);
        final VCategoryItemBinding binding = (VCategoryItemBinding) holder.binding;
        //noinspection unchecked
        binding.mediaHorizontalList.setManagerType(viewModel.getManagerType());
        try {
            binding.mediaHorizontalList.getMedia(viewModel.getCategoryName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
