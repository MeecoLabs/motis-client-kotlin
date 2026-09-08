/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class StepInstruction(
    val relativeDirection: Direction,
    val distance: Double,
    val fromLevel: Int,
    val toLevel: Int,
    val osmWay: Int? = null,
    val polyline: EncodedPolyline,
    val streetName: String,
    val exit: String,
    val stayOn: Boolean,
    val area: Boolean,
    val toll: Boolean? = null,
    val accessRestriction: String? = null,
    val elevationUp: Int? = null,
    val elevationDown: Int? = null
)
