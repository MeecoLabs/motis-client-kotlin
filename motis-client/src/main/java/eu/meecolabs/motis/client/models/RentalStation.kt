/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RentalStation(
    val id: String,
    val providerId: String,
    val providerGroupId: String,
    val name: String,
    val lat: Double,
    val lon: Double,
    val address: String? = null,
    val crossStreet: String? = null,
    val rentalUriAndroid: String? = null,
    val rentalUriIOS: String? = null,
    val rentalUriWeb: String? = null,
    val isRenting: Boolean,
    val isReturning: Boolean,
    val numVehiclesAvailable: Int,
    val formFactors: List<RentalFormFactor>,
    val vehicleTypesAvailable: Map<String, Int>,
    val vehicleDocksAvailable: Map<String, Int>,
    val stationArea: List<MultiPolygons>? = null,
    val bbox: List<Double>
)
