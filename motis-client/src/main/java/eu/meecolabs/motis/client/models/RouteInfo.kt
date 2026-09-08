/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RouteInfo(
    val mode: TransitMode,
    val transitRoutes: List<TransitRouteInfo>,
    val numStops: Int,
    val routeIdx: Int,
    val pathSource: RoutePathSource,
    val segments: List<RouteSegment>
)
