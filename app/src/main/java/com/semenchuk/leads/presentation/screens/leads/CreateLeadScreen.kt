package com.semenchuk.leads.presentation.screens.leads

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.semenchuk.leads.R
import com.semenchuk.leads.ui.components.DropdownWidget
import com.semenchuk.leads.ui.components.LeadTextInput
import com.semenchuk.leads.ui.theme.LeadsTheme
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreateLeadScreen(
    createLeadScreenViewModel: CreateLeadScreenViewModel = koinViewModel(),
) {
    val state: CreateLeadScreenViewModel.CreateLeadState =
        createLeadScreenViewModel.state.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                item { LeadTextInput("First name", "John") }
                item { LeadTextInput("Last name", "Doe") }
                item {
                    DropdownWidget(
                        fieldHint = stringResource(R.string.lead_intention),
                        selectableItems = state.deps.listLeadIntentionType
                    )
                }
                item {
                    DropdownWidget(
                        fieldHint = stringResource(R.string.ad_source),
                        selectableItems = state.deps.listAdSource
                    )
                }
                item {
                    DropdownWidget(
                        fieldHint = stringResource(R.string.country),
                        selectableItems = state.deps.listCountries
                    )
                }
                item {
                    DropdownWidget(
                        fieldHint = stringResource(R.string.language),
                        selectableItems = state.deps.listLanguages
                    )
                }
                item {
                    LeadTextInput(
                        stringResource(R.string.phone_number),
                        stringResource(R.string.phone_num_placeholder)
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CreateLeadScreenPreview() {
    LeadsTheme {
        CreateLeadScreen()
    }
}