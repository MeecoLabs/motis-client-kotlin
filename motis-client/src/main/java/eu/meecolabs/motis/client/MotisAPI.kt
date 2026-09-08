/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client

import eu.meecolabs.motis.client.interceptors.UserAgentInterceptor
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

/**
 * Motis API.
 *
 * Default backends by https://transitous.org/api/
 */
@Suppress("unused")
object MotisAPI {
    sealed class Endpoint(
        val baseUrl: String
    ) {
        data object PRODUCTION : Endpoint("https://api.transitous.org/api/")

        data object STAGING : Endpoint("https://staging.api.transitous.org/api/")

        class CUSTOM(
            baseUrl: String
        ) : Endpoint(baseUrl)
    }

    fun create(
        userAgent: String,
        endpoint: Endpoint = Endpoint.PRODUCTION,
        json: Json = Json {
            ignoreUnknownKeys = true
            allowSpecialFloatingPointValues = true
        },
        isDebug: Boolean = false
    ): MotisService {
        val client = OkHttpClient.Builder()
            .addInterceptor(UserAgentInterceptor(userAgent))

        if (isDebug) {
            client.addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
        }

        val retrofit = Retrofit.Builder()
            .client(client.build())
            .baseUrl(endpoint.baseUrl)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

        return retrofit.create(MotisService::class.java)
    }
}
