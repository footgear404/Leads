package com.semenchuk.leads.domain

import com.semenchuk.leads.domain.models.AdSource
import com.semenchuk.leads.domain.models.Country
import com.semenchuk.leads.domain.models.Language
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.models.LeadIntentionType
import com.semenchuk.leads.domain.models.LeadsPaginated

interface LeadsApolloClient {

    suspend fun getCountries(): List<Country>

    suspend fun getLeads(): LeadsPaginated

    suspend fun fetchAdSources(): List<AdSource>
    suspend fun fetchLeadIntentionTypes(): List<LeadIntentionType>
    suspend fun languages(): List<Language>

    //    suspend fun createLead() : Lead
}