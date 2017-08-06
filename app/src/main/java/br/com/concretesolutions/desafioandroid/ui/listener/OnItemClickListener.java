package br.com.concretesolutions.desafioandroid.ui.listener;

import android.databinding.ViewDataBinding;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public interface OnItemClickListener<T extends Parcelable, D extends ViewDataBinding> {
    void onItemClick(@NonNull T object, int position, @NonNull D binding);
}