package br.com.concretesolutions.desafioandroid.utils

import br.com.concretesolutions.desafioandroid.BuildConfig
import okhttp3.Request

object RequestUtils {

    private val languageIndex = 0
    private val sortIndex = 1
    private val pageIndex = 2

    fun requestEndpoint(request: Request): String {
        val baseUrlSize = BuildConfig.BASE_URL.length
        return request.url().toString().substring(baseUrlSize)
    }

    fun removeQueryFromUrl(url: String): String {
        val queryIndex = url.indexOf("?")
        return url.substring(0, queryIndex)
    }

    fun languageParam(request: Request): String {
        return request.url().queryParameterValue(languageIndex)
    }

    fun sortParam(request: Request): String {
        return request.url().queryParameterValue(sortIndex)
    }

    fun pageParam(request: Request): String {
        return request.url().queryParameterValue(pageIndex)
    }

    fun requestBaseUrl(request: Request): String {
        val urlSize = BuildConfig.BASE_URL.length
        return request.url().toString().substring(0, urlSize)
    }
}