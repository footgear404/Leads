package com.semenchuk.leads.domain

import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.models.CreateLeadScreenDeps

interface CreateLeadsRepository {

    suspend fun getDependencies(): CreateLeadScreenDeps

    suspend fun createLead(lead: Lead)

}