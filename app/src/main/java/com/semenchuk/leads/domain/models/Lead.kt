package com.semenchuk.leads.domain.models

data class Lead(
    val id: Int,
    val avatar: Avatar?,
    val country: Country?,
    val status: Status?,
    val displayName: String?,
    val firstName: String?,
    val lastName: String?,
    val secondName: String?,
)
