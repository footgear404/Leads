package com.semenchuk.leads.domain

import com.semenchuk.leads.domain.models.Country


class GetCountriesUseCase(
    private val leadsApolloClient: LeadsApolloClient,
) {
    suspend fun execute(): List<Country> {
        return leadsApolloClient
            .getCountries()
            .sortedBy { it.title }
    }
}