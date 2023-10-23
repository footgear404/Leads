package com.semenchuk.leads.domain.models

data class CreateLeadScreenDeps(
    val listLeadIntentionType: List<LeadIntentionType>,
    val listAdSource: List<AdSource>,
    val listCountries: List<Country>,
    val listLanguages: List<Language>,
)
