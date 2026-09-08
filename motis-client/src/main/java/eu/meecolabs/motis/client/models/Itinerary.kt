/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class Itinerary(
    val duration: Long,
    val startTime: Instant,
    val endTime: Instant,
    val transfers: Int,
    val id: String,
    val legs: List<Leg>,
    val fareTransfers: List<FareTransfer>? = null
    )
