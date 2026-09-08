/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class Rental(
    val providerId: String,
    val providerGroupId: String,
    val systemId: String,
    val systemName: String? = null,
    val url: String? = null,
    val color: String? = null,
    val stationName: String? = null,
    val fromStationName: String? = null,
    val toStationName: String? = null,
    val rentalUriAndroid: String? = null,
    val rentalUriIOS: String? = null,
    val rentalUriWeb: String? = null,
    val formFactor: RentalFormFactor? = null,
    val propulsionType: RentalPropulsionType? = null,
    val returnConstraint: RentalReturnConstraint? = null
)
