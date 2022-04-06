package com.goodideas.goodbookreview.util

/**
 * Resource 用於接收restful api response
 *
 * @param T
 * @property data
 * @property message
 * @constructor Create empty Resource
 */
sealed class Resource<out T>(
    data: T? = null,
    message: String? = null,
) {
    class Success<out T>(data: T) : Resource<T>(data)
    class Error<T>(
        message: String,
        data: T? = null,
    ) : Resource<T>(data, message)
    //class Loading<T>(data: T? = null) : Resource<T>(data)
    class Loading<T> : Resource<T>()
}