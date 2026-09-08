/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RentalVehicle(
    val id: String,
    val providerId: String,
    val providerGroupId: String,
    val typeId: String,
    val lat: Double,
    val lon: Double,
    val formFactor: RentalFormFactor,
    val propulsionType: RentalPropulsionType,
    val returnConstraint: RentalReturnConstraint,
    val stationId: String? = null,
    val homeStationId: String? = null,
    val isReserved: Boolean,
    val isDisabled: Boolean,
    val rentalUriAndroid: String? = null,
    val rentalUriIOS: String? = null,
    val rentalUriWeb: String? = null
)
