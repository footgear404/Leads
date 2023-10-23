package com.semenchuk.leads.data.apollo

import com.apollographql.apollo3.ApolloClient
import com.semenchuk.leads.AdSourceQuery
import com.semenchuk.leads.CountriesQuery
import com.semenchuk.leads.CreateLeadMutation
import com.semenchuk.leads.LanguagesQuery
import com.semenchuk.leads.LeadIntentionQuery
import com.semenchuk.leads.LeadsQuery
import com.semenchuk.leads.data.toAdSource
import com.semenchuk.leads.data.toCountry
import com.semenchuk.leads.data.toLanguage
import com.semenchuk.leads.data.toLeadIntentionType
import com.semenchuk.leads.data.toLeads
import com.semenchuk.leads.domain.LeadsApolloClient
import com.semenchuk.leads.domain.models.AdSource
import com.semenchuk.leads.domain.models.Country
import com.semenchuk.leads.domain.models.Language
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.models.LeadIntentionType
import com.semenchuk.leads.domain.models.LeadsPaginated
import com.semenchuk.leads.type.PaginationInput

open class LeadsApolloClientImpl(
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

    override suspend fun fetchLeadIntentionTypes(): List<LeadIntentionType> {
        return apolloClient
            .query(LeadIntentionQuery())
            .execute()
            .data
            ?.fetchLeadIntentionTypes
            ?.map {
                it.toLeadIntentionType()
            }
            ?: emptyList()
    }

    override suspend fun fetchAdSources(): List<AdSource> {
        return apolloClient
            .query(AdSourceQuery())
            .execute()
            .data
            ?.fetchAdSources
            ?.map {
                it.toAdSource()
            }
            ?: emptyList()
    }

    override suspend fun languages(): List<Language> {
        return apolloClient
            .query(LanguagesQuery())
            .execute()
            .data
            ?.languages
            ?.map {
                it.toLanguage()
            } ?: emptyList()
    }

//    override suspend fun createLead(): Lead {
//        return apolloClient.mutation(
//            CreateLeadMutation.CreateLead(
//
//            )
//                .data
//
//        )
//    }
}