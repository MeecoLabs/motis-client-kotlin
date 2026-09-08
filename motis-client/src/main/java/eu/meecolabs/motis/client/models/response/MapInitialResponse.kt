/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.response

import eu.meecolabs.motis.client.models.ServerConfig
import kotlinx.serialization.Serializable

@Serializable
data class MapInitialResponse(
    val lat: Double,
    val lon : Double,
    val zoom: Double,
    val serverConfig: ServerConfig
)
