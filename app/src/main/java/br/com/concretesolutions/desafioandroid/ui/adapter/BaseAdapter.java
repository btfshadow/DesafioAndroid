package br.com.concretesolutions.desafioandroid.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.concretesolutions.desafioandroid.ui.listener.OnItemClickListener;

public class BaseAdapter<T extends Parcelable> extends RecyclerView.Adapter<ViewHolder> {

    private static final String STATE_LIST = "STATE_LIST";

    @LayoutRes
    private final int layoutRes;
    @Nullable
    private OnItemClickListener listener;
    private LayoutInflater layoutInflater;
    private List<T> list = new ArrayList<>();

    public BaseAdapter(@LayoutRes final int layoutRes) {
        this.layoutRes = layoutRes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(getLayoutInflater(parent), layoutRes, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final T model = list.get(position);
        holder.binding.getRoot().setOnClickListener(v -> {
            if (listener != null) //noinspection unchecked
                listener.onItemClick(model, position, holder.binding);
        });
        holder.bind(model, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void restoreInstanceState(@Nullable final Bundle bundle) {
        if (bundle == null) return;
        list = bundle.getParcelableArrayList(STATE_LIST);
    }

    @NonNull
    public Bundle saveInstanceState() {
        final Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(STATE_LIST, new ArrayList<>(list));
        return bundle;
    }

    public final <D extends ViewDataBinding, V extends BaseAdapter<T>> V clickListener(@Nullable final OnItemClickListener<T, D> listener) {
        this.listener = listener;
        //noinspection unchecked
        return (V) this;
    }

    // region List handle methods
    public void addNewItems(@NonNull final List<T> newItems) {
        final int start = getItemCount();
        this.list.addAll(newItems);
        notifyItemRangeInserted(start, newItems.size());
    }

    public final void setList(@NonNull final List<T> list) {
        clearList();
        addNewItems(list);
    }

    public final boolean removeItem(@NonNull final T item) {
        final int indexOnList = list.indexOf(item);
        if (indexOnList < 0) return false;
        notifyItemRemoved(indexOnList);
        list.remove(indexOnList);
        return true;
    }

    public final boolean insertOrUpdateItem(@NonNull final T item) {
        final int indexOnAdapter = list.indexOf(item);
        final boolean wasEmpty = list.isEmpty();
        if (indexOnAdapter >= 0) {
            list.set(indexOnAdapter, item);
            final int indexOnAdapterAfter = list.indexOf(item);
            if (indexOnAdapter != indexOnAdapterAfter) {
                notifyItemMoved(indexOnAdapter, indexOnAdapterAfter);
            }
            notifyItemChanged(indexOnAdapterAfter);
        } else {
            list.add(0, item);
            notifyItemInserted(0);
        }
        return wasEmpty;
    }

    public void clearList() {
        list.clear();
        notifyDataSetChanged();
    }

    public T getItem(int position) {
        return list.get(position);
    }
    // endregion

    private LayoutInflater getLayoutInflater(@NonNull final ViewGroup parent) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());
        return layoutInflater;
    }
}
