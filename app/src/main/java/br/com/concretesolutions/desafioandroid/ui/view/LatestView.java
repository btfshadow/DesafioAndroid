package br.com.concretesolutions.desafioandroid.ui.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import br.com.concretesolutions.desafioandroid.databinding.ViewLatestBinding;
import br.com.concretesolutions.desafioandroid.viewmodel.LatestMovieViewModel;

public class LatestView extends FrameLayout {

    private ViewLatestBinding binding;

    public LatestView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public LatestView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LatestView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        binding = ViewLatestBinding.inflate(LayoutInflater.from(context), this, true);
    }

    public void movie(final LatestMovieViewModel movieViewModel) {
        binding.setObj(movieViewModel);
    }

}
