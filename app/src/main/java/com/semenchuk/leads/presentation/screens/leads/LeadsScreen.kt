package com.semenchuk.leads.presentation.screens.leads

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.semenchuk.leads.R
import com.semenchuk.leads.domain.models.Avatar
import com.semenchuk.leads.domain.models.Country
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.domain.models.Status
import com.semenchuk.leads.domain.utils.RouteConstants
import com.semenchuk.leads.ui.components.Button
import com.semenchuk.leads.ui.components.ButtonType
import com.semenchuk.leads.ui.components.CircularFlagEmoji
import com.semenchuk.leads.ui.components.LeadStatusBadgeItem
import com.semenchuk.leads.ui.components.TopAppBar
import com.semenchuk.leads.ui.theme.LeadsTheme
import com.semenchuk.leads.ui.utils.color
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

@Preview
@Composable
private fun LeadsScreenPreview() {
    LeadsTheme {
        LeadsScreen(
            navController = rememberNavController()
        )
    }
}

@Composable
private fun LeadItem(
    lead: Lead,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .height(45.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(lead.avatar?.path),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .border(1.dp, "#d5d5d5".color(), shape = CircleShape)
                .clip(CircleShape)
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = "${lead.displayName}",
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                letterSpacing = 0.15.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            CircularFlagEmoji(
                modifier = Modifier
                    .padding(top = 2.dp)
                    .background(Color.Gray, shape = CircleShape)
                    .size(16.dp)
                    .clip(shape = CircleShape),
                emoji = lead.country?.emoji ?: "🇨🇩",
            )
        }
        LeadStatusBadgeItem(
            text = lead.status!!.title,
            color = lead.status.color.color(),
            background = lead.status.backgroundColor.color()
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewLeadItem() {
    LeadsTheme {
        val lead = Lead(
            id = 1, Avatar(
                0,
                null,
                "https://s3.eu-west-1.amazonaws.com/ae.axcrm/cetxxD0yPmi9Wgf5PQixaLte1f4gkN5R.png"
            ), Country(
                id = 0, emoji = "🇧🇬", phoneCode = "", title = "As"
            ), Status(
                0,
                "New",
                "#175CD3",
                "#EFF8FF"
            ), "Test User", null, null, null
        )
        LeadItem(lead = lead)
    }
}
