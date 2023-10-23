package com.semenchuk.leads.di

import com.semenchuk.leads.domain.CreateLeadsRepository
import com.semenchuk.leads.domain.LeadsApolloClient
import com.semenchuk.leads.domain.usecases.CreteLeadUseCase
import com.semenchuk.leads.domain.usecases.GetLeadsUseCase
import org.koin.dsl.module

val domainModule = module {

    single<GetLeadsUseCase> {
        GetLeadsUseCase(
            leadsApolloClient = get<LeadsApolloClient>()
        )
    }

    single<CreteLeadUseCase> {
        CreteLeadUseCase(
            createLeadsRepository = get<CreateLeadsRepository>()
        )
    }

}