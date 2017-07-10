package br.com.concretesolutions.desafioandroid.databinding;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.ui.transformation.RoundedCornerTransformation;

public final class PicassoBindingAdapter {

    @BindingAdapter(value = {"android:src"}, requireAll = false)
    public static void setImageUrl(ImageView view, String url) {
        if (TextUtils.isEmpty(url)) {
            view.setImageResource(R.drawable.ic_broken_image);
            return;
        }

        view.setImageResource(R.drawable.ic_image_placeholder);
        Picasso.with(view.getContext())
                    .load(url)
                    .transform(new RoundedCornerTransformation(10, 0))
                    .into(view, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            view.setImageResource(R.drawable.ic_refresh);
                        }
                    });

    }

    private PicassoBindingAdapter() {
        // No instances!
    }
}
