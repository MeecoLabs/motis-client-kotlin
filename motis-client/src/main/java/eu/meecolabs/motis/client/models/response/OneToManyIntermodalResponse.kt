/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.response

import eu.meecolabs.motis.client.models.Duration
import eu.meecolabs.motis.client.models.ParetoSet
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OneToManyIntermodalResponse(
    @SerialName("street_durations")
    val streetDurations: List<Duration>? = null,
    @SerialName("transit_durations")
    val transitDurations: List<ParetoSet>? = null
)
