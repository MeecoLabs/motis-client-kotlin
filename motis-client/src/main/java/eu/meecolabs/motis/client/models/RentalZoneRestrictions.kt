/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RentalZoneRestrictions(
    val vehicleTypeIdxs: List<Int>,
    val rideStartAllowed: Boolean,
    val rideEndAllowed: Boolean,
    val rideThroughAllowed: Boolean,
    val stationParking: Boolean? = null
)
