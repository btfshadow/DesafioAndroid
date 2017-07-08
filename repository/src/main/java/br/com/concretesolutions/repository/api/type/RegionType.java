package br.com.concretesolutions.repository.api.type;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.concretesolutions.repository.api.type.RegionType.BR;
import static br.com.concretesolutions.repository.api.type.RegionType.EN;


@Retention(RetentionPolicy.SOURCE)
@StringDef({BR, EN})
public @interface RegionType {
    String BR = "BR";
    String EN = "EN";
}
