/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class TimeRange(
    val start: Instant?,
    val end: Instant?,
)
