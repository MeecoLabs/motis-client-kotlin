/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.interceptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Make sure the user agent is sent on every single OkHTTP request.
 */
class UserAgentInterceptor(
    private val userAgent: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("User-Agent", userAgent)

        return chain.proceed(request.build())
    }
}
