/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RentalProvider(
    val id: String,
    val name: String,
    val groupId: String,
    val operator: String? = null,
    val url: String? = null,
    val purchaseUrl: String? = null,
    val color: String? = null,
    val bbox: List<Double>,
    val vehicleTypes: List<RentalVehicleType>,
    val formFactors: List<RentalFormFactor>,
    val defaultRestrictions: RentalZoneRestrictions,
    val globalGeofencingRules: List<RentalZoneRestrictions>,
)
