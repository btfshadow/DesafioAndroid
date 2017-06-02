package br.com.concretesolutions.repository.utils
import br.com.concretesolutions.repository.BuildConfig

object RequestUtils {

    private val languageIndex = 0
    private val sortIndex = 1
    private val pageIndex = 2

    fun requestEndpoint(request: okhttp3.Request): String {
        val baseUrlSize = BuildConfig.BASE_URL.length
        return request.url().toString().substring(baseUrlSize)
    }

    fun removeQueryFromUrl(url: String): String {
        val queryIndex = url.indexOf("?")
        return url.substring(0, queryIndex)
    }

    fun languageParam(request: okhttp3.Request): String {
        return request.url().queryParameterValue(languageIndex)
    }

    fun sortParam(request: okhttp3.Request): String {
        return request.url().queryParameterValue(sortIndex)
    }

    fun pageParam(request: okhttp3.Request): String {
        return request.url().queryParameterValue(pageIndex)
    }

    fun requestBaseUrl(request: okhttp3.Request): String {
        val urlSize = BuildConfig.BASE_URL.length
        return request.url().toString().substring(0, urlSize)
    }
}