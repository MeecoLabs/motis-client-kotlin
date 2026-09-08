/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class FareProduct(
    val name: String,
    val amount: Double,
    val currency: String,
    val riderCategory: RiderCategory? = null,
    val media: FareMedia? = null
)
