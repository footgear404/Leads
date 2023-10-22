package com.semenchuk.leads.ui.utils

import android.content.Context
import androidx.navigation.NavController
import com.semenchuk.leads.domain.LeadsApolloClient
import com.semenchuk.leads.domain.models.Avatar
import com.semenchuk.leads.domain.models.Country
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.models.LeadsPaginated
import com.semenchuk.leads.domain.models.Status
import com.semenchuk.leads.domain.usecases.GetLeadsUseCase
import com.semenchuk.leads.ui.screens.leads.LeadScreenViewModel


object FakeItem {
    val fakeLeadScreenViewModel = LeadScreenViewModel(
        getLeadsUseCase = GetLeadsUseCase(
            object : LeadsApolloClient {
                override suspend fun getCountries(): List<Country> {
                    TODO("Not yet implemented")
                }

                override suspend fun getLeads(): LeadsPaginated {
                    TODO("Not yet implemented")
                }
            }
        )
    )

    fun fakeNavController(context: Context): NavController = NavController(context = context)

    val lead = Lead(
        id = 1, Avatar(
            0,
            null,
            "https://s3.eu-west-1.amazonaws.com/ae.axcrm/cetxxD0yPmi9Wgf5PQixaLte1f4gkN5R.png"
        ), Country(
            id = 0, emoji = "🇧🇬", phoneCode = "", title = "As"
        ), Status(
            0,
            "New",
            "#175CD3",
            "#EFF8FF"
        ), "Test User", null, null, null
    )
}