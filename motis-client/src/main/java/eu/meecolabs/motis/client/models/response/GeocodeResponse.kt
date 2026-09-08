/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.response

import eu.meecolabs.motis.client.models.Area
import eu.meecolabs.motis.client.models.LocationType
import eu.meecolabs.motis.client.models.Token
import eu.meecolabs.motis.client.models.TransitMode
import kotlinx.serialization.Serializable

@Serializable
data class GeocodeResponse(
    val type: LocationType,
    val category: String? = null,
    val tokens: List<Token>,
    val name: String,
    val id: String,
    val lat: Double,
    val lon: Double,
    val level: Int? = null,
    val street: String? = null,
    val houseNumber: String? = null,
    val country: String? = null,
    val zip: String? = null,
    val tz: String? = null,
    val areas: List<Area>,
    val score: Double,
    val modes: List<TransitMode>? = null,
    val importance: Double? = null
)
