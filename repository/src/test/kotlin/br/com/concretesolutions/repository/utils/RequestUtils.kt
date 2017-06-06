package br.com.concretesolutions.repository.utils

import br.com.concretesolutions.repository.BuildConfig
import okhttp3.Request

private val languageIndex = 0
private val pageIndex = 1
private val regionIndex = 2

fun requestEndpoint(request: Request): String {
    val baseUrlSize = BuildConfig.BASE_URL.length
    return request.url().toString().substring(baseUrlSize)
}

fun pageParam(request: Request): String {
    return request.url().queryParameterValue(pageIndex)
}

fun requestBaseUrl(request: Request): String {
    val urlSize = BuildConfig.BASE_URL.length
    return request.url().toString().substring(0, urlSize)
}

fun regionParam(request: Request): String {
    return request.url().queryParameterValue(regionIndex)
}

fun languageParam(request: Request): String {
    return request.url().queryParameterValue(languageIndex)
}