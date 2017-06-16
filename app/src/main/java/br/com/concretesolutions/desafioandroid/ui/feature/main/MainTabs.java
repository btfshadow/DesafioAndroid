package br.com.concretesolutions.desafioandroid.ui.feature.main;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.concretesolutions.desafioandroid.ui.feature.main.MainTabs.MOVIE;
import static br.com.concretesolutions.desafioandroid.ui.feature.main.MainTabs.PROFILE;
import static br.com.concretesolutions.desafioandroid.ui.feature.main.MainTabs.TV_SHOW;


@Retention(RetentionPolicy.CLASS)
@StringDef({MOVIE, TV_SHOW, PROFILE})
public @interface MainTabs {
    String MOVIE = "MOVIE";
    String TV_SHOW = "TV_SHOW";
    String PROFILE = "PROFILE";
}
