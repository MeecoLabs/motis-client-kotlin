/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.response

import eu.meecolabs.motis.client.models.FareTransfer
import eu.meecolabs.motis.client.models.Leg
import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class TripResponse(
    val duration: Int,
    val startTime: Instant,
    val endTime: Instant,
    val transfers: Int,
    val id: String,
    val legs: List<Leg>,
    val fareTransfers: List<FareTransfer>? = null
)
