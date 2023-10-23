package com.semenchuk.leads.domain.models

data class Language(
    override val id: Int,
    val countries: List<Country>,
    val shortCode: String,
    override val title: String,
) : DropDownWidgetType
