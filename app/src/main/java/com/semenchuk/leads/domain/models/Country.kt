package com.semenchuk.leads.domain.models

data class Country(
    val id: Int,
    val title: String,
    val emoji: String?,
    val phoneCode: String,
)
