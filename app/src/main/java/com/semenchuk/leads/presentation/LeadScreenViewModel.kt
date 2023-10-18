package com.semenchuk.leads.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semenchuk.leads.domain.GetLeadsUseCase
import com.semenchuk.leads.domain.models.LeadsPaginated
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LeadScreenViewModel(
    private val getLeadsUseCase: GetLeadsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<LeadsState>(LeadsState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            delay(2000)
            _state.update {
                it.copy(
                    leads = getLeadsUseCase.execute(),
                    isLoading = false
                )
            }

            state.collect {
                Log.d("TAG", "STATE: $it")
            }
        }
    }

    data class LeadsState(
        val leads: LeadsPaginated = LeadsPaginated(
            cursor = null,
            data = emptyList(),
            hasMore = false,
            totalCount = 0
        ),
        val isLoading: Boolean = false,
    )
}