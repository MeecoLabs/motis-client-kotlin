/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class TransitRouteInfo(
    val id: String,
    val shortName: String,
    val longName: String,
    val color: String? = null,
    val textColor: String? = null
)
