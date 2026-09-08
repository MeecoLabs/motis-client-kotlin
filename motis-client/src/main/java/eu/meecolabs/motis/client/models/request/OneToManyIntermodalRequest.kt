/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.request

import eu.meecolabs.motis.client.models.ElevationCosts
import eu.meecolabs.motis.client.models.PedestrianProfile
import eu.meecolabs.motis.client.models.TransitMode
import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class OneToManyIntermodalRequest(
    val one: String,
    val many: List<String>,
    val time: Instant? = null,
    val maxTravelTime: Int? = null,
    val maxMatchingDistance: Double? = null,
    val arriveBy: Boolean? = null,
    val maxTransfers: Int? = null,
    val minTransferTime: Int? = null,
    val additionalTransferTime: Int? = null,
    val transferTimeFactor: Double? = null,
    val useRoutedTransfers: Boolean? = null,
    val pedestrianProfile: PedestrianProfile? = null,
    val pedestrianSpeed: Double? = null,
    val cyclingSpeed: Double? = null,
    val elevationCosts: ElevationCosts? = null,
    val transitModes: List<TransitMode>? = null,
    val preTransitModes: List<TransitMode>? = null,
    val postTransitModes: List<TransitMode>? = null,
    val directMode: List<TransitMode>? = null,
    val maxPreTransitTime: Int? = null,
    val maxPostTransitTime: Int? = null,
    val maxDirectTime: Int? = null,
    val withDistance: Boolean? = null,
    val requireBikeTransport: Boolean? = null,
    val requireCarTransport: Boolean? = null
)
