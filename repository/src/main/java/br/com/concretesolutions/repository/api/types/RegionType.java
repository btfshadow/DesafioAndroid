package br.com.concretesolutions.repository.api.types;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.concretesolutions.repository.api.types.RegionType.BR;
import static br.com.concretesolutions.repository.api.types.RegionType.EN;


@Retention(RetentionPolicy.CLASS)
@StringDef({BR, EN})
public @interface RegionType {
    String BR = "BR";
    String EN = "EN";
}
