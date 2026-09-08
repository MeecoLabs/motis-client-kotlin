/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class StopTime(
    val place: Place,
    val mode: TransitMode,
    val realTime: Boolean,
    val headsign: String,
    val tripFrom: Place,
    val tripTo: Place,
    val agencyId: String,
    val agencyName: String,
    val agencyUrl: String,
    val routeId: String,
    val routeUrl: String? = null,
    val directionId: String,
    val routeColor: String? = null,
    val routeTextColor: String? = null,
    val tripId: String,
    val routeType: String? = null,
    val routeShortName: String,
    val routeLongName: String,
    val tripShortName: String,
    val displayName: String,
    val previousStops: List<Place>? = null,
    val nextStops: List<Place>? = null,
    val pickupDropoffType: PickupDropoffType,
    val cancelled: Boolean,
    val tripCancelled: Boolean,
    val source: String
)
