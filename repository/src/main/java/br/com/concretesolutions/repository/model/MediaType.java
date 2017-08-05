package br.com.concretesolutions.repository.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StringRes;

public class MediaType implements Parcelable {

    private @StringRes int categoryName;
    private @MediaTypes int type;

    public MediaType(final int categoryName, @MediaTypes int type) {
        this.categoryName = categoryName;
        this.type = type;
    }

    public @StringRes int getCategoryName() {
        return categoryName;
    }

    public @MediaTypes int getType() {
        return type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.categoryName);
        dest.writeInt(this.type);
    }

    @SuppressWarnings("WrongConstant")
    protected MediaType(Parcel in) {
        this.categoryName = in.readInt();
        this.type = in.readInt();
    }

    public static final Creator<MediaType> CREATOR = new Creator<MediaType>() {
        @Override
        public MediaType createFromParcel(Parcel source) {
            return new MediaType(source);
        }

        @Override
        public MediaType[] newArray(int size) {
            return new MediaType[size];
        }
    };
}
