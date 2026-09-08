/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class MapTrip(
    val trips: List<TripInfo>,
    val routeColor: String? = null,
    val mode: TransitMode,
    val distance: Double,
    val from: Place,
    val to: Place,
    val departure: Instant,
    val arrival: Instant,
    val scheduledDeparture: Instant,
    val scheduledArrival: Instant,
    val realTime: Boolean,
    val polyline: String
)
