package br.com.concretesolutions.desafioandroid.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StringRes;

import java.util.ArrayList;
import java.util.List;

import br.com.concretesolutions.desafioandroid.manager.MediaManagerType;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;

public class CategoryViewModel implements Parcelable{

    private @StringRes int categoryName;
    private @MediaManagerType int manager;


    public CategoryViewModel(final int categoryName, @MediaManagerType int manager) {
        this.categoryName = categoryName;
        this.manager = manager;
    }

    public @StringRes int getCategoryName() {
        return categoryName;
    }

    public @MediaManagerType int getManagerType() {
        return manager;
    }

    public static List<MediaItemViewModel> getViewModelList(final Page<Media> mediaPage) {
        List<MediaItemViewModel> viewModelList = new ArrayList<>();

        for (Media media : mediaPage.results())
            viewModelList.add(new MediaItemViewModel(media));

        return viewModelList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.categoryName);
        dest.writeInt(this.manager);
    }

    @SuppressWarnings("WrongConstant")
    protected CategoryViewModel(Parcel in) {
        this.categoryName = in.readInt();
        this.manager = in.readInt();
    }

    public static final Creator<CategoryViewModel> CREATOR = new Creator<CategoryViewModel>() {
        @Override
        public CategoryViewModel createFromParcel(Parcel source) {
            return new CategoryViewModel(source);
        }

        @Override
        public CategoryViewModel[] newArray(int size) {
            return new CategoryViewModel[size];
        }
    };
}
