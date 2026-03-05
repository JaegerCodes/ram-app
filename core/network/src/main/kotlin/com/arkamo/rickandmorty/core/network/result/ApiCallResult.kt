package com.arkamo.rickandmorty.core.network.result

import retrofit2.Response

suspend fun <T, R> apiCall(
    call: suspend () -> Response<T>,
    onSuccess: (T) -> R,
    onFailure: (String) -> R,
): R = try {
    val response = call()
    if (response.isSuccessful) {
        val body = response.body()
        if (body != null) onSuccess(body)
        else onFailure("Empty response body")
    } else {
        onFailure(response.errorBody()?.string() ?: "HTTP ${response.code()}")
    }
} catch (throwable: Throwable) {
    onFailure(throwable.message ?: "Network error")
}
