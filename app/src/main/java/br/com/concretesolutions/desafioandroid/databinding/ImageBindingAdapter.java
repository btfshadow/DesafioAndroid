package br.com.concretesolutions.desafioandroid.databinding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.view.View;
import android.widget.ImageView;

public final class ImageBindingAdapter {

    @BindingAdapter("android:src")
    public static void setImageUri(ImageView view, String imageUri) {
        if (imageUri == null) {
            view.setImageURI(null);
        } else {
            view.setImageURI(Uri.parse(imageUri));
        }
    }

    @BindingAdapter("android:selected")
    public static void setSelected(ImageView view, boolean selected) {
        view.setSelected(selected);
    }

    @BindingAdapter("android:src")
    public static void setImageDrawable(ImageView view, Drawable drawable) {
        view.setImageDrawable(drawable);
    }

    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    @BindingAdapter("android:background")
    public static void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    @BindingAdapter("android:background")
    public static void setBackgroundResource(View view, @ColorInt int resource) {
        view.setBackgroundColor(resource);
    }

    private ImageBindingAdapter() {
        // No instances!
    }
}
