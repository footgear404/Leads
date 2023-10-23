package com.semenchuk.leads.domain.models

data class LeadIntentionType(
    override val id: Int,
    override val title: String,
) : DropDownWidgetType
