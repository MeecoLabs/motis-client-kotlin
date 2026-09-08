/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.response

import eu.meecolabs.motis.client.models.Place
import eu.meecolabs.motis.client.models.StopTime
import kotlinx.serialization.Serializable

@Serializable
data class StopTimesResponse(
    val stopTimes: List<StopTime>,
    val place: Place,
    val previousPageCursor: String,
    val nextPageCursor: String
)
