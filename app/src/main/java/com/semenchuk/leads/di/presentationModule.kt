package com.semenchuk.leads.di

import com.semenchuk.leads.domain.GetCountriesUseCase
import com.semenchuk.leads.domain.GetLeadsUseCase
import com.semenchuk.leads.presentation.CountriesViewModel
import com.semenchuk.leads.presentation.LeadScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel<CountriesViewModel> {
        CountriesViewModel(getCountriesUseCase = get<GetCountriesUseCase>())
    }

    viewModel<LeadScreenViewModel> {
        LeadScreenViewModel(getLeadsUseCase = get<GetLeadsUseCase>())
    }
}