package br.com.concretesolutions.repository.api.type;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.concretesolutions.repository.api.type.LanguageType.EN_US;
import static br.com.concretesolutions.repository.api.type.LanguageType.PT_BR;


@Retention(RetentionPolicy.SOURCE)
@StringDef({PT_BR, EN_US})
public @interface LanguageType {
    String PT_BR = "pt-BR";
    String EN_US = "en-US";
}
