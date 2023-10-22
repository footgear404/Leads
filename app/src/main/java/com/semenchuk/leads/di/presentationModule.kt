package com.semenchuk.leads.di

import com.semenchuk.leads.domain.usecases.GetCountriesUseCase
import com.semenchuk.leads.domain.usecases.GetLeadsUseCase
import com.semenchuk.leads.presentation.CountriesViewModel
import com.semenchuk.leads.ui.screens.leads.LeadScreenViewModel
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