package com.semenchuk.leads.di

import com.apollographql.apollo3.ApolloClient
import com.semenchuk.leads.data.CreateLeadsRepositoryImpl
import com.semenchuk.leads.data.apollo.ApolloAuthorizationInterceptor
import com.semenchuk.leads.data.apollo.LeadsApolloClientImpl
import com.semenchuk.leads.domain.CreateLeadsRepository
import com.semenchuk.leads.domain.LeadsApolloClient
import com.semenchuk.leads.domain.utils.LeadConstants.URL
import org.koin.dsl.module

val dataModule = module {

    single<ApolloClient> {
        ApolloClient.Builder()
            .serverUrl(URL)
            .addHttpInterceptor(ApolloAuthorizationInterceptor())
            .build()

    }
    single<LeadsApolloClient> {
        LeadsApolloClientImpl(apolloClient = get<ApolloClient>())
    }

    single<CreateLeadsRepository> {
        CreateLeadsRepositoryImpl(leadsApolloClient = get<LeadsApolloClient>())
    }
}