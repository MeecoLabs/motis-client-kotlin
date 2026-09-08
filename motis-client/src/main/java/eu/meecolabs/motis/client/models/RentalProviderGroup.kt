/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RentalProviderGroup(
    val id: String,
    val name: String,
    val color: String? = null,
    val providers: List<String>,
    val formFactors: List<RentalFormFactor>
)
