/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class Leg(
    val mode: TransitMode,
    val from: Place,
    val to: Place,
    val duration: Long,
    val startTime: Instant,
    val endTime: Instant,
    val scheduledStartTime: Instant,
    val scheduledEndTime: Instant,
    val realTime: Boolean,
    val scheduled: Boolean,
    val distance: Double? = null,
    val interlineWithPreviousLeg: Boolean? = null,
    val headsign: String? = null,
    val tripFrom: Place? = null,
    val tripTo: Place? = null,
    val category: Category? = null,
    val routeId: String? = null,
    val routeUrl: String? = null,
    val directionId: String? = null,
    val routeColor: String? = null,
    val routeTextColor: String? = null,
    val routeType: Int? = null,
    val agencyName: String? = null,
    val agencyUrl: String? = null,
    val agencyId: String? = null,
    val tripId: String? = null,
    val routeShortName: String? = null,
    val routeLongName: String? = null,
    val tripShortName: String? = null,
    val displayName: String? = null,
    val cancelled: Boolean? = null,
    val source: String? = null,
    val intermediateStops: List<Place>? = null,
    val legGeometry: EncodedPolyline? = null,
    val steps: List<StepInstruction>? = null,
    val rental: Rental? = null,
    val fareTransferIndex: Int? = null,
    val effectiveFareLegIndex: Int? = null,
    val alerts: List<Alert>? = null,
    val loopedCalendarSince: Instant? = null,
    val bikesAllowed: Boolean? = null,
    val wheelchairAccessible: WheelchairAccessibility? = null,
    val alternatives: List<Leg>? = null
)
