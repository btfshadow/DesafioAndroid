package br.com.concretesolutions.desafioandroid.databinding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import br.com.concretesolutions.desafioandroid.ui.transformation.RoundedCornerTransformation;

public final class PicassoBindingAdapter {

    @BindingAdapter(value = {"android:src", "placeHolder"}, requireAll = false)
    public static void setImageUrl(ImageView view, String url, int placeHolder) {
        RequestCreator requestCreator = Picasso.with(view.getContext()).load(url);
        if (placeHolder != 0)
            requestCreator.placeholder(placeHolder);

        requestCreator.transform(new RoundedCornerTransformation(10, 0))
                .into(view);
    }

    @BindingAdapter(value = {"android:src", "placeHolder"}, requireAll = false)
    public static void setImageUrl(ImageView view, String url, Drawable placeHolder) {
        if (TextUtils.isEmpty(url)) view.setImageDrawable(placeHolder);
        else Picasso.with(view.getContext()).load(url).placeholder(placeHolder).into(view);
    }

    private PicassoBindingAdapter() {
        // No instances!
    }
}
