package br.com.concretesolutions.desafioandroid.ui.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import br.com.concretesolutions.desafioandroid.databinding.VMovieItemBinding;
import br.com.concretesolutions.desafioandroid.viewmodel.MovieItemViewModel;

public class MovieItemView extends FrameLayout {

    private VMovieItemBinding binding;

    public MovieItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MovieItemView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(@NonNull final Context context) {
        binding = VMovieItemBinding.inflate(LayoutInflater.from(context), this, true);
    }

    public void movie(final MovieItemViewModel viewModel) {
        binding.setObj(viewModel);
    }
}
