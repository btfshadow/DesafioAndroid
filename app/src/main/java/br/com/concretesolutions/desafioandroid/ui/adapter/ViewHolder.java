package br.com.concretesolutions.desafioandroid.ui.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import br.com.concretesolutions.desafioandroid.BR;


public final class ViewHolder extends RecyclerView.ViewHolder {

    public final ViewDataBinding binding;

    public ViewHolder(@NonNull final ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(@NonNull final Object object, final int index) {
        binding.setVariable(BR.obj, object);
//        binding.setVariable(BR.index, index);
        binding.executePendingBindings();
    }
}
