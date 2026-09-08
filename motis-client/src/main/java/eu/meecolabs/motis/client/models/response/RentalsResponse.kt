/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.response

import eu.meecolabs.motis.client.models.RentalProvider
import eu.meecolabs.motis.client.models.RentalProviderGroup
import eu.meecolabs.motis.client.models.RentalStation
import eu.meecolabs.motis.client.models.RentalVehicle
import eu.meecolabs.motis.client.models.RentalZone
import kotlinx.serialization.Serializable

@Serializable
data class RentalsResponse(
    val providerGroups: List<RentalProviderGroup>,
    val providers: List<RentalProvider>,
    val stations: List<RentalStation>,
    val vehicles: List<RentalVehicle>,
    val zones: List<RentalZone>,
)
