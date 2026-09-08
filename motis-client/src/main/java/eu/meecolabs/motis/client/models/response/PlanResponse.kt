/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.response

import eu.meecolabs.motis.client.models.Itinerary
import eu.meecolabs.motis.client.models.Place
import kotlinx.serialization.Serializable

@Serializable
data class PlanResponse(
    val requestParameters: Map<String, String>,
    val debugOutput: Map<String, Int>,
    val from: Place,
    val to: Place,
    val direct: List<Itinerary>,
    val itineraries: List<Itinerary>,
    val previousPageCursor: String,
    val nextPageCursor: String
)
