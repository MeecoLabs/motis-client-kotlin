/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RentalZone(
    val providerId: String,
    val providerGroupId: String,
    val name: String? = null,
    val z: Int,
    val bbox: List<Double>,
    val area: List<MultiPolygons>,
    val rules: List<RentalZoneRestrictions>
)
