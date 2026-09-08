/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class Area(
    val name: String,
    val adminLevel: Int,
    val matched: Boolean,
    val unique: Boolean? = null,
    val default: Boolean? = null
)
