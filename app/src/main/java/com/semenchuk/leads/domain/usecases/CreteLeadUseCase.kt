package com.semenchuk.leads.domain.usecases

import com.semenchuk.leads.domain.CreateLeadsRepository
import com.semenchuk.leads.domain.models.CreateLeadInput
import com.semenchuk.leads.domain.models.CreateLeadScreenDeps

class CreteLeadUseCase(
    private val createLeadsRepository: CreateLeadsRepository,
) {
    suspend fun execute(): CreateLeadScreenDeps {
        return createLeadsRepository.getDependencies()
    }

    suspend fun save(lead: CreateLeadInput) {

    }
}