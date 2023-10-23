package com.semenchuk.leads.ui.common_components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.semenchuk.leads.domain.utils.RouteConstants.ADD_LEAD
import com.semenchuk.leads.domain.utils.RouteConstants.CALLS
import com.semenchuk.leads.domain.utils.RouteConstants.CHAT
import com.semenchuk.leads.domain.utils.RouteConstants.HOME
import com.semenchuk.leads.domain.utils.RouteConstants.LEADS
import com.semenchuk.leads.domain.utils.RouteConstants.MORE
import com.semenchuk.leads.presentation.screens.leads.CreateLeadScreen
import com.semenchuk.leads.presentation.screens.leads.LeadsScreen


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
) {
    NavHost(navController = navHostController, startDestination = LEADS) {
        composable(HOME) { }
        composable(CALLS) { }
        composable(CHAT) { }
        composable(LEADS) { LeadsScreen(navController = navHostController) }
        composable(ADD_LEAD) {
            CreateLeadScreen()
        }
        composable(MORE) { }
    }
}