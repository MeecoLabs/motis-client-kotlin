/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.request

import eu.meecolabs.motis.client.models.PedestrianProfile
import eu.meecolabs.motis.client.models.TransitMode
import kotlinx.serialization.Serializable

@Serializable
data class RefreshItineraryRequest(
    val itineraryId: String,
    val requireDisplayNameMatch: Boolean? = null,
    val joinInterlinedLegs: Boolean? = null,
    val detailedTransfers: Boolean? = null,
    val detailedLegs: Boolean? = null,
    val withFares: Boolean? = null,
    val withScheduledSkippedStops: Boolean? = null,
    val numLegAlternatives: Int? = null,
    val transitModes: List<TransitMode>? = null,
    val pedestrianProfile: PedestrianProfile? = null,
    val useRoutedTransfers: Boolean? = null,
    val requireBikeTransport: Boolean? = null,
    val requireCarTransport: Boolean? = null,
    val language: List<String>? = null
)
