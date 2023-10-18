package com.semenchuk.leads.domain

import com.semenchuk.leads.domain.models.LeadsPaginated

class GetLeadsUseCase(
    private val leadsApolloClient: LeadsApolloClient,
) {
    suspend fun execute(): LeadsPaginated {
        return leadsApolloClient.getLeads()
    }
}