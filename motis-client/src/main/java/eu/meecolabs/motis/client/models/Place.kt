/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class Place(
    val name: String,
    val stopId: String? = null,
    val parentId: String? = null,
    val importance: Double? = null,
    val lat: Double,
    val lon: Double,
    val level: Int? = null,
    val tz: String? = null,
    val arrival: Instant? = null,
    val departure: Instant? = null,
    val scheduledArrival: Instant? = null,
    val scheduledDeparture: Instant? = null,
    val scheduledTrack: String? = null,
    val track: String? = null,
    val stopCode: String? = null,
    val description: String? = null,
    val vertexType: VertexType? = null,
    val pickupType: PickupDropoffType? = null,
    val dropoffType: PickupDropoffType? = null,
    val cancelled: Boolean? = null,
    val alerts: List<Alert>? = null,
    val flex: String? = null,
    val flexId: String? = null,
    val flexStartPickupDropOffWindow: Instant? = null,
    val flexEndPickupDropOffWindow: Instant? = null,
    val modes: TransitMode? = null
)
