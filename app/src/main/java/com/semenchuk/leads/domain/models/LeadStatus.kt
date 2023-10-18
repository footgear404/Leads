package com.semenchuk.leads.domain.models

data class LeadStatus(
    val backgroundColor: String,
    val color: String,
    val id: Int,
    val legacyColor: String,
    val step: Int,
    val stepsCount: Int,
    val title: String,
)
