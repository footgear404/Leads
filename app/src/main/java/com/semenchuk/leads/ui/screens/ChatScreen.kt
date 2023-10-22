package com.semenchuk.leads.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.semenchuk.leads.presentation.CountriesViewModel

@Composable
fun ChatScreen(
    navController: NavController,
) {
    val viewModel: CountriesViewModel = viewModel()
    Text(text = "ChatScreen")
}