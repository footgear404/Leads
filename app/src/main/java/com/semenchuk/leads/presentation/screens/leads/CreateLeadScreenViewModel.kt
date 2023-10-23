package com.semenchuk.leads.presentation.screens.leads

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semenchuk.leads.domain.models.CreateLeadScreenDeps
import com.semenchuk.leads.domain.usecases.CreteLeadUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CreateLeadScreenViewModel(
    creteLeadUseCase: CreteLeadUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CreateLeadState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            _state.update {
                it.copy(
                    deps = creteLeadUseCase.execute(),
                    isLoading = false
                )
            }
            state.collect {

            }
        }

    }

    data class CreateLeadState(
        val deps: CreateLeadScreenDeps = CreateLeadScreenDeps(
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList()
        ),
        val isLoading: Boolean = false,
    )
}