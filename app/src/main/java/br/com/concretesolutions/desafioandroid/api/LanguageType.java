package br.com.concretesolutions.desafioandroid.api;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.concretesolutions.desafioandroid.api.LanguageType.JAVA;
import static br.com.concretesolutions.desafioandroid.api.LanguageType.KOTLIN;
import static br.com.concretesolutions.desafioandroid.api.LanguageType.PHP;

@Retention(RetentionPolicy.CLASS)
@StringDef({JAVA, KOTLIN, PHP})
public @interface LanguageType {
    String JAVA = "language:java";
    String KOTLIN = "language:kotlin";
    String PHP = "language:php";
}
