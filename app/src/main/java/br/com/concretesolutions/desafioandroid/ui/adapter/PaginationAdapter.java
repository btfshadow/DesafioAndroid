package br.com.concretesolutions.desafioandroid.ui.adapter;

import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import br.com.concretesolutions.desafioandroid.databinding.VProgressItemBinding;
import br.com.concretesolutions.repository.model.Page;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class PaginationAdapter<T extends Parcelable> extends BaseAdapter<T> {

    private static final String PROGRESS_TAG = "PaginationAdapter.PROGRESS_TAG";
    private static final int VIEW_PROGRESS = 0;
    private static final int VIEW_ITEM = 1;

    private OnLoadMoreListener listener;
    private boolean hasLoadingItem;
    private boolean hasError;
    private int currentPage = 1;

    public PaginationAdapter(@LayoutRes int layoutRes, @NonNull final OnLoadMoreListener listener) {
        super(layoutRes);
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        if (viewType != VIEW_PROGRESS)
            return super.onCreateViewHolder(parent, viewType);
        else
            return new ViewHolder(VProgressItemBinding.inflate(getLayoutInflater(parent), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        if (getItemViewType(position) != VIEW_PROGRESS)
            super.onBindViewHolder(viewHolder, position);
        else {
            final VProgressItemBinding binder = (VProgressItemBinding) viewHolder.binding;
            binder.getRoot().setTag(PROGRESS_TAG);
            binder.progressBar.setVisibility(hasError ? GONE : VISIBLE);
            binder.errorText.setVisibility(hasError ? VISIBLE : GONE);
            binder.errorText.setOnClickListener(view -> listener.onLoadMore(currentPage));
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.clearOnChildAttachStateChangeListeners();
        recyclerView.addOnChildAttachStateChangeListener(childAttachListener());
    }

    private RecyclerView.OnChildAttachStateChangeListener childAttachListener() {
        return new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
                if (view.getTag() != null
                        && view.getTag().equals(PROGRESS_TAG)
                        && !hasError)
                    listener.onLoadMore(currentPage);
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
            }
        };
    }

    @Override
    public int getItemViewType(final int position) {
        return position == getList().size() ? VIEW_PROGRESS : VIEW_ITEM;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + (hasLoadingItem ? 1 : 0);
    }

    @Override
    public void clearList() {
        if (hasLoadingItem) removeLoadingItem();
        super.clearList();
    }

    public void addPage(@NonNull final Page<T> page) {
        hasError = false;
        currentPage++;
        if (hasLoadingItem) removeLoadingItem();
        addNewItems(page.results());

        if (currentPage <= page.totalPages())
            insertLoadingItem();
    }

    public void failPage() {
        if (!hasLoadingItem) return;
        hasError = true;
        notifyItemChanged(getItemCount());
    }

    private void insertLoadingItem() {
        notifyItemInserted(getItemCount());
        hasLoadingItem = true;
    }

    private void removeLoadingItem() {
        hasLoadingItem = false;
        notifyItemRemoved(getItemCount());
    }

    public interface OnLoadMoreListener {
        void onLoadMore(int page);
    }
}
