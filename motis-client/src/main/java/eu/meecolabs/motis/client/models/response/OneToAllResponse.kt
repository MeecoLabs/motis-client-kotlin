/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.response

import eu.meecolabs.motis.client.models.Place
import eu.meecolabs.motis.client.models.ReachablePlace
import kotlinx.serialization.Serializable

@Serializable
data class OneToAllResponse(
    val one: Place? = null,
    val all: List<ReachablePlace>? = null
)
