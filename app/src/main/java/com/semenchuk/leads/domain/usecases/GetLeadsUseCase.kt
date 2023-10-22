package com.semenchuk.leads.domain.usecases

import com.semenchuk.leads.domain.LeadsApolloClient
import com.semenchuk.leads.domain.models.LeadsPaginated

class GetLeadsUseCase(
    private val leadsApolloClient: LeadsApolloClient,
) {
    suspend fun execute(): LeadsPaginated {
        return leadsApolloClient.getLeads()
    }
}