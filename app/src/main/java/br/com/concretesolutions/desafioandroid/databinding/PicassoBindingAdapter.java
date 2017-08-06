package br.com.concretesolutions.desafioandroid.databinding;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.ui.transformation.RoundedCornerTransformation;

public final class PicassoBindingAdapter {

    @BindingAdapter(value = {"android:src"}, requireAll = false)
    public static void setImageUrl(ImageView view, String url) {
        loadIntoImageView(view, url, true);
    }

    @BindingAdapter(value = {"app:backdrop"})
    public static void setImageBackdrop(ImageView view, String url) {
        loadIntoImageView(view, url, false);
    }

    private static void loadIntoImageView(ImageView view, String url, boolean transform) {
        if (TextUtils.isEmpty(url)) {
            view.setImageResource(R.drawable.ic_broken_image);
            return;
        }

        view.setImageResource(R.drawable.ic_image_placeholder);
        RequestCreator requestCreator = Picasso.with(view.getContext()).load(url);

        if (transform)
            requestCreator.transform(new RoundedCornerTransformation(10, 0));

        requestCreator
                .fit()
                .into(view, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError() {
                view.setImageResource(R.drawable.ic_refresh);
                view.setOnClickListener(v -> loadIntoImageView((ImageView) v, url, transform));
            }
        });
    }

    private PicassoBindingAdapter() {
        // No instances!
    }
}
