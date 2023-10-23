package com.semenchuk.leads.data

import com.semenchuk.leads.domain.CreateLeadsRepository
import com.semenchuk.leads.domain.LeadsApolloClient
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.models.CreateLeadScreenDeps

class CreateLeadsRepositoryImpl(
    private val leadsApolloClient: LeadsApolloClient,
) : CreateLeadsRepository {
    override suspend fun getDependencies(): CreateLeadScreenDeps {
        return CreateLeadScreenDeps(
            listLeadIntentionType = leadsApolloClient.fetchLeadIntentionTypes(),
            listAdSource = leadsApolloClient.fetchAdSources(),
            listCountries = leadsApolloClient.getCountries(),
            listLanguages = leadsApolloClient.languages()
        )
    }

    override suspend fun createLead(lead: Lead) {
        TODO("Not yet implemented")
    }

}