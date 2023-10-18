package com.semenchuk.leads.data.apollo

import com.apollographql.apollo3.ApolloClient
import com.semenchuk.leads.CountriesQuery
import com.semenchuk.leads.LeadsQuery
import com.semenchuk.leads.data.toCountry
import com.semenchuk.leads.data.toLeads
import com.semenchuk.leads.domain.LeadsApolloClient
import com.semenchuk.leads.domain.models.Country
import com.semenchuk.leads.domain.models.LeadsPaginated
import com.semenchuk.leads.type.PaginationInput

class LeadsApolloClientImpl(
    private val apolloClient: ApolloClient,
) : LeadsApolloClient {
    override suspend fun getCountries(): List<Country> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.fetchCountries
            ?.map {
                it.toCountry()
            } ?: emptyList()
    }

    override suspend fun getLeads(): LeadsPaginated {
        return apolloClient
            .query(
                LeadsQuery(
                    pagination = PaginationInput()
                )
            )
            .execute()
            .data
            ?.fetchLeads?.toLeads() ?: LeadsPaginated(
            cursor = null,
            data = emptyList(),
            hasMore = false,
            totalCount = 0
        )
    }
}