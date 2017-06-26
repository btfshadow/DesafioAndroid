package br.com.concretesolutions.desafioandroid.manager;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.concretesolutions.desafioandroid.manager.MediaManagerType.MOVIE;
import static br.com.concretesolutions.desafioandroid.manager.MediaManagerType.TV;


@Retention(RetentionPolicy.CLASS)
@IntDef({MOVIE, TV})
public @interface MediaManagerType {
    int MOVIE = 0;
    int TV = 1;
}
