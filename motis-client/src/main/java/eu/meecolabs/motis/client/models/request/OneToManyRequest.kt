/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.request

import eu.meecolabs.motis.client.models.ElevationCosts
import eu.meecolabs.motis.client.models.TransitMode
import kotlinx.serialization.Serializable

@Serializable
data class OneToManyRequest(
    val one: String,
    val many: List<String>,
    val mode: List<TransitMode>,
    val max: Double,
    val maxMatchingDistance: Double,
    val elevationCosts: ElevationCosts? = null,
    val arriveBy: Boolean,
    val withDistance: Boolean? = null
)
