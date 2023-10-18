package com.semenchuk.leads.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.semenchuk.leads.ui.components.AppNavGraph
import com.semenchuk.leads.ui.components.BottomAppNavBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomAppNavBar(
            navController = navController
        ) }
    ) {
        AppNavGraph(navHostController = navController)
    }
}