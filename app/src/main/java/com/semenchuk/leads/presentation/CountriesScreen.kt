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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.semenchuk.leads.domain.models.Country
import com.semenchuk.leads.ui.theme.LeadsTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CountriesScreen(
    countriesViewModel: CountriesViewModel = koinViewModel(),
//    onSelectCountry: (title: String) -> Unit,
) {
    val state = countriesViewModel.state.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.countries) { country ->
                    Log.d("TAG", "$state")
                    CountryItem(
                        country = country,
                        modifier = Modifier
                            .fillMaxWidth()
//                            .clickable { onSelectCountry(country.title) }
                            .padding(16.dp))
                }
            }
        }
    }
}

@Composable
private fun CountryItem(
    country: Country,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = country.emoji.toString(),
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = country.title, fontSize = 24.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = country.phoneCode, fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LeadsTheme {
        CountriesScreen(
//            onSelectCountry = {}
        )
    }
}

fun countryClick(country: String) {
    Log.d("CLICK", "countryClick: $country")
}