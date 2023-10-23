package com.semenchuk.leads.domain.models

data class Country(
    override val id: Int,
    override val title: String,
    val emoji: String?,
    val phoneCode: String,
) : DropDownWidgetType
