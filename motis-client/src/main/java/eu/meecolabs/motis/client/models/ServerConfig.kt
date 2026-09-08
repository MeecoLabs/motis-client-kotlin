/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class ServerConfig(
    val motisVersion: String,
    val hasElevation: Boolean,
    val hasRoutedTransfers: Boolean,
    val hasStreetRouting: Boolean,
    val maxOneToManySize: Double,
    val maxOneToAllTravelTimeLimit: Double,
    val maxPrePostTransitTimeLimit: Double,
    val maxDirectTimeLimit: Double,
    val shapesDebugEnabled: Boolean
)
