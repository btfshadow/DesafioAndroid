package br.com.concretesolutions.repository.api.types;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.concretesolutions.repository.api.types.LanguageType.EN_US;
import static br.com.concretesolutions.repository.api.types.LanguageType.PT_BR;


@Retention(RetentionPolicy.CLASS)
@StringDef({PT_BR, EN_US})
public @interface LanguageType {
    String PT_BR = "pt-BR";
    String EN_US = "en-US";
}
