package com.semenchuk.leads.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semenchuk.leads.domain.usecases.GetCountriesUseCase
import com.semenchuk.leads.domain.models.Country
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val getCountriesUseCase: GetCountriesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
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
                    countries = getCountriesUseCase.execute(),
                    isLoading = false
                )
            }
        }
    }

    fun countryClick(country: String) {
        Log.d("CLICK", "countryClick: $country")
    }

    data class CountriesState(
        val countries: List<Country> = emptyList(),
        val isLoading: Boolean = false,
    )

}