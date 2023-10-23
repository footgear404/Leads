package com.semenchuk.leads.domain.models

data class CreateLeadInput(
    val leadSourceId: Int,
    val firstName: String,
    val lastName: String,
    val secondName: String?,
    val languageIds: List<Int>,
    val intentionId: Int,
    val countryId: Int,
    val contacts: List<ContactData>,
)