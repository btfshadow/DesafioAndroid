package br.com.concretesolutions.desafioandroid.ui.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class CustomItemDecoration extends RecyclerView.ItemDecoration {

    private final int defaultSpace;

    public CustomItemDecoration(int defaultSpace) {
        this.defaultSpace = defaultSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = defaultSpace;
        outRect.right = defaultSpace;
    }
}
