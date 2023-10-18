package com.semenchuk.leads.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ChatScreen(
    navController: NavController,
) {
    val viewModel: CountriesViewModel = viewModel()
    Text(text = "ChatScreen")
}