/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RentalVehicleType(
    val id: String,
    val name: String? = null,
    val formFactor: RentalFormFactor,
    val propulsionType: RentalPropulsionType,
    val returnConstraint: RentalReturnConstraint,
    val returnConstraintGuessed: Boolean
)
