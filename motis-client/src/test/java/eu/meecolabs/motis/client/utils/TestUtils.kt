/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.utils

import eu.meecolabs.motis.client.MotisAPI
import eu.meecolabs.motis.client.MotisService
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

object TestUtils {
    /**
     * Reads a resource file from the classpath as a String.
     */
    fun readResourceText(path: String): String {
        val normalizedPath = if (path.startsWith("/")) path else "/$path"
        val inputStream = TestUtils::class.java.getResourceAsStream(normalizedPath)
            ?: throw IllegalArgumentException("Resource file not found at path: $normalizedPath")
        return inputStream.bufferedReader().use { it.readText() }
    }

    /**
     * Enqueues a response on the [okhttp3.mockwebserver.MockWebServer] using a JSON fixture file from classpath resources.
     */
    fun MockWebServer.enqueueFixture(
        fixturePath: String,
        responseCode: Int = 200,
        headers: Map<String, String> = emptyMap()
    ) {
        val bodyText = readResourceText(fixturePath)
        val response = MockResponse()
            .setResponseCode(responseCode)
            .setBody(bodyText)
            .addHeader("Content-Type", "application/json")

        headers.forEach { (key, value) ->
            response.addHeader(key, value)
        }

        enqueue(response)
    }

    /**
     * Creates a [eu.meecolabs.motis.client.MotisService] instance pointing to the given [MockWebServer].
     */
    fun createTestService(mockWebServer: MockWebServer): MotisService {
        val customEndpoint = MotisAPI.Endpoint.CUSTOM(mockWebServer.url("/").toString())
        return MotisAPI.create(
            userAgent = "MotisClientTest/1.0",
            endpoint = customEndpoint,
            isDebug = false
        )
    }
}
