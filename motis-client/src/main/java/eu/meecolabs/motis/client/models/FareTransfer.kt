/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class FareTransfer(
    val rule: FareTransferRule? = null,
    val transferProducts: List<FareProduct>? = null,
    val effectiveFareLegProducts: List<List<FareProduct>>
)
