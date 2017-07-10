package br.com.concretesolutions.desafioandroid;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;

import br.com.concretesolutions.desafioandroid.ui.base.BaseActivity;

public class ViewTestActivity extends BaseActivity {

    private ViewDataBinding binding;
    private static final String LAYOUT_ID = "LAYOUT_ID";
    private static final String IS_DATA_BINDING = "IS_DATA_BINDING";
    private static final String DATA_BINDING_OBJ = "DATA_BINDING_OBJ";

    public static <T extends Parcelable> Intent intent(@LayoutRes int layoutId, boolean isDataBinding, T obj) {
        Intent intent = new Intent();
        intent.putExtra(LAYOUT_ID, layoutId);
        intent.putExtra(IS_DATA_BINDING, isDataBinding);
        intent.putExtra(DATA_BINDING_OBJ, obj);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutId = getIntent().getIntExtra(LAYOUT_ID, 0);
        boolean isDataBinding = getIntent().getBooleanExtra(IS_DATA_BINDING, false);
        if (isDataBinding) {
            binding = DataBindingUtil.setContentView(this, layoutId);
            Object obj = getIntent().getParcelableExtra(DATA_BINDING_OBJ);
            if (obj != null)
                setObj(obj);
        } else
            setContentView(layoutId);
    }

    public <T extends View> T getView(@IdRes int viewId) {
        //noinspection unchecked
        return (T) findViewById(viewId);
    }

    public void setObj(Object obj) {
        binding.setVariable(BR.obj, obj);
    }
}
