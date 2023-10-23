package com.semenchuk.leads.di

import com.semenchuk.leads.MainActivity
import com.semenchuk.leads.domain.usecases.CreteLeadUseCase
import com.semenchuk.leads.domain.usecases.GetCountriesUseCase
import com.semenchuk.leads.domain.usecases.GetLeadsUseCase
import com.semenchuk.leads.presentation.CountriesViewModel
import com.semenchuk.leads.presentation.screens.leads.CreateLeadScreenViewModel
import com.semenchuk.leads.presentation.screens.leads.LeadScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<LeadScreenViewModel> {
        LeadScreenViewModel(getLeadsUseCase = get<GetLeadsUseCase>())
    }

    viewModel<CreateLeadScreenViewModel> {
        CreateLeadScreenViewModel(creteLeadUseCase = get<CreteLeadUseCase>())
    }
}