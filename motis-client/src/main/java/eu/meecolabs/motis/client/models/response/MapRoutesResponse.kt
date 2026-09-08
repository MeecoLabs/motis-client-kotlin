/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.response

import eu.meecolabs.motis.client.models.Place
import eu.meecolabs.motis.client.models.RouteInfo
import eu.meecolabs.motis.client.models.RoutePolyline
import kotlinx.serialization.Serializable

@Serializable
data class MapRoutesResponse(
    val routes: List<RouteInfo>,
    val polylines: List<RoutePolyline>,
    val stops: List<Place>,
    val zoomFiltered: Boolean
)
