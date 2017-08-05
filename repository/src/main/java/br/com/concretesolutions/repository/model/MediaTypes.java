package br.com.concretesolutions.repository.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.concretesolutions.repository.model.MediaTypes.MOVIE;
import static br.com.concretesolutions.repository.model.MediaTypes.TV;


@Retention(RetentionPolicy.SOURCE)
@IntDef({MOVIE, TV})
public @interface MediaTypes {
    int MOVIE = 0;
    int TV = 1;
}
