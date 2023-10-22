package com.semenchuk.leads.domain

import com.semenchuk.leads.domain.models.Country
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.models.LeadsPaginated

interface LeadsApolloClient {

    suspend fun getCountries(): List<Country>

    suspend fun getLeads(): LeadsPaginated

//    suspend fun createLead() : Lead
}