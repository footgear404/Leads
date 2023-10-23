package com.semenchuk.leads.ui.utils

import android.content.Context
import androidx.navigation.NavController
import com.semenchuk.leads.domain.models.AdSource
import com.semenchuk.leads.domain.models.Avatar
import com.semenchuk.leads.domain.models.Country
import com.semenchuk.leads.domain.models.CreateLeadScreenDeps
import com.semenchuk.leads.domain.models.Language
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.models.LeadIntentionType
import com.semenchuk.leads.domain.models.Status


object FakeItem {
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

    val createLeadScreenDeps = CreateLeadScreenDeps(
        listOf(LeadIntentionType(0, "one"), LeadIntentionType(0, "two")),
        listOf(AdSource(0, "one"), AdSource(0, "two")),
        listOf(Country(0, "one", "", ""), Country(0, "two", "", "")),
        listOf(Language(0, emptyList(), "", ""), Language(0, emptyList(), "", "")),
    )
}