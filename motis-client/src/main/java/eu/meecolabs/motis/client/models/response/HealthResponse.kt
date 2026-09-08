/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models.response

import kotlinx.serialization.Serializable

@Serializable
data class HealthResponse(
    val rt: Boolean,
    val gbfs: Boolean
)
