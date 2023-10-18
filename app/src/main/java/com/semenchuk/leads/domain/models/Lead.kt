package com.semenchuk.leads.domain.models

import com.semenchuk.leads.type.DateTime
import com.semenchuk.leads.type.ItemType

data class Lead(
    val birthDate: DateTime?,
    val budget: Double?,
    val createdAt: DateTime?,
    val displayName: String?,
    val displaySource: String?,
    val firstName: String?,
    val id: Int,
    val itemType: ItemType,
    val lastName: String?,
    val personId: Int,
    val quality: Int?,
    val secondName: String?,
    val seen: Boolean?,
    val sourceDetails: String?,
    val updatedAt: DateTime?,
)
