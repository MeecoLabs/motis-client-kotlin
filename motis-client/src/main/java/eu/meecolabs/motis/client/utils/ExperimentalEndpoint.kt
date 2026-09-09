/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.utils

@RequiresOptIn(
    level = RequiresOptIn.Level.WARNING,
    message = "This Motis API endpoint is experimental."
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION)
annotation class ExperimentalEndpoint
