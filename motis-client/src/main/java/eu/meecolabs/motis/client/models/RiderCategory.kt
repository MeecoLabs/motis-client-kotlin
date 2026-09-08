/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RiderCategory(
    val riderCategoryName: String,
    val isDefaultFareCategory: Boolean,
    val eligibilityUrl: String? = null
)
