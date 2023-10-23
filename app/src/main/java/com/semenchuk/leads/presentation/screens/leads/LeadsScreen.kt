package com.semenchuk.leads.presentation.screens.leads

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.semenchuk.leads.R
import com.semenchuk.leads.domain.utils.RouteConstants
import com.semenchuk.leads.ui.components.Button
import com.semenchuk.leads.ui.components.ButtonType
import com.semenchuk.leads.ui.components.LeadItem
import com.semenchuk.leads.ui.components.TopAppBar
import com.semenchuk.leads.ui.theme.LeadsTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun LeadsScreen(
    leadViewModel: LeadScreenViewModel = koinViewModel(),
    navController: NavController,
) {
    val state: LeadScreenViewModel.LeadsState = leadViewModel.state.collectAsState().value

    val buttons = listOf<Button>(
        Button(
            type = ButtonType.ROUTE(
                path = RouteConstants.ADD_LEAD,
                icon = R.drawable.user_plus
            )
        ),
        Button(
            type = ButtonType.SEARCH(
                icon = R.drawable.search
            )
        ),
    )

    Column {

        TopAppBar(buttons = buttons, navController = navController)

        Box(modifier = Modifier.fillMaxSize()) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                if (state.leads.data.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
                        items(state.leads.data) { lead ->
                            LeadItem(
                                lead = lead,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { Log.d("CLICK", "${lead.id}") }
                                    .padding(8.dp))
                        }
                    }
                } else {
                    Text(
                        text = "No one lead found",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun LeadsScreenPreview() {
    LeadsTheme {
        LeadsScreen(
            navController = rememberNavController()
        )
    }
}