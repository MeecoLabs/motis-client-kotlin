/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RoutePolyline(
    val polyline: EncodedPolyline,
    val colors: List<String>,
    val routeIndexes: List<Int>
)
