package com.semenchuk.leads.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.semenchuk.leads.R
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.utils.RouteConstants
import com.semenchuk.leads.presentation.components.AppBar
import com.semenchuk.leads.presentation.components.Button
import com.semenchuk.leads.presentation.components.ButtonType
import org.koin.androidx.compose.koinViewModel

@Composable
fun LeadsScreen(
    leadViewModel: LeadScreenViewModel = koinViewModel(),
    navController: NavController,
) {
    val state = leadViewModel.state.collectAsState().value

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

        AppBar(buttons = buttons, navController = navController)

        Box(modifier = Modifier.fillMaxSize()) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                if (state.leads.data.isNotEmpty()) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.leads.data) { lead ->

                            LeadItem(
                                lead = lead,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { Log.d("CLICK", "${lead.id}") }
                                    .padding(16.dp))
                        }
                    }
                } else {
                    Text(
                        text = "No one leads@",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun LeadItem(
    lead: Lead,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "${lead.firstName} ${lead.lastName}", fontSize = 24.sp)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}
