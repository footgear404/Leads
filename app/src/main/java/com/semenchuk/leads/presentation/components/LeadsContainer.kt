//package com.semenchuk.leads.presentation.components
//
//import android.annotation.SuppressLint
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.res.stringResource
//import com.semenchuk.leads.navigation.NavigationController
//import com.semenchuk.leads.navigation.Router
//import com.semenchuk.leads.navigation.Screen
//import com.semenchuk.leads.ui.screens.leads.LeadsScreen
//
//@ExperimentalAnimationApi
//@Composable
//fun LeadsContainer(
//    externalRouter: Router,
//) {
//    NavigationController(
//        startDestination = Screen.Leads.screenName,
//        router = externalRouter,
//        screens = listOf(
//            Pair(Screen.Leads.screenName) { nav, router, _ ->
//                LeadsScreen(
//                    title = stringResource(id = Screen.Leads.titleResourceId),
//                    router = router,
//                    navController = nav
//                )
//            },
//            Pair(Screen.Lead.screenName) { _, _, params ->
//                LeadScreen(leadId = params!!.getInt("KEY"))
//            }
//        )
//    )
//}
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun LeadScreen(leadId: Int) {
//
//    Scaffold {
//        Text(text = "lead screen with id: $leadId")
//    }
//
//}
