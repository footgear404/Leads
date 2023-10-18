package com.semenchuk.leads.di

import com.semenchuk.leads.domain.GetCountriesUseCase
import com.semenchuk.leads.domain.GetLeadsUseCase
import com.semenchuk.leads.domain.LeadsApolloClient
import org.koin.dsl.module

val domainModule = module {
    single<GetCountriesUseCase> {
        GetCountriesUseCase(
            leadsApolloClient = get<LeadsApolloClient>()
        )
    }

    single<GetLeadsUseCase> {
        GetLeadsUseCase(
            leadsApolloClient = get<LeadsApolloClient>()
        )
    }
}