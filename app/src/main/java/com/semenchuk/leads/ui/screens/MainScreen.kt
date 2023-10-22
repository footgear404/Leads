//package com.semenchuk.leads.ui.screens
//
//import android.annotation.SuppressLint
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.semenchuk.leads.navigation.Router
//import com.semenchuk.leads.navigation.Screen
//import com.semenchuk.leads.presentation.components.LeadsContainer
//import com.semenchuk.leads.ui.components.BottomAppNavBar
//
//@OptIn(ExperimentalAnimationApi::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun MainScreen(
//    router: Router,
//) {
//    val navController = rememberNavController()
//
//    Scaffold(
//        bottomBar = {
//            BottomAppNavBar(navController = navController)
//        }
//    ) {
//        NavHost(navController = navController, startDestination = Screen.Leads.screenName) {
//            composable(Screen.Leads.screenName) { LeadsContainer(externalRouter = router) }
//            composable(Screen.Home.screenName) { HomeScreen(router = router, navController = navController) }
//        }
//    }
//}