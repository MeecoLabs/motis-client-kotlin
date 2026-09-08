/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class TripInfo(
    val tripId: String,
    val routeShortName: String? = null,
    val displayName: String? = null
)
