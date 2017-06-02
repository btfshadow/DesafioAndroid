package br.com.concretesolutions.desafioandroid.api.types;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.concretesolutions.desafioandroid.api.types.SortType.FORKS;
import static br.com.concretesolutions.desafioandroid.api.types.SortType.STARS;

@Retention(RetentionPolicy.CLASS)
@StringDef({STARS, FORKS})
public @interface SortType {
    String STARS = "stars";
    String FORKS = "forks";
}