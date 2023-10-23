package com.semenchuk.leads.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.semenchuk.leads.R
import com.semenchuk.leads.domain.utils.RouteConstants.ADD_LEAD
import com.semenchuk.leads.ui.theme.LeadsTheme
import com.semenchuk.leads.ui.theme.shapes

@Composable
fun SquareButtonWithIcon(
    icon: Int,
    onClick: (route: String) -> Unit,
) {
    IconButton(
        modifier = Modifier
            .padding(10.dp)
            .background(LeadsTheme.colors.gray_100, shape = shapes.small),
        onClick = { onClick(ADD_LEAD) }
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = icon),
            contentDescription = "icon"
        )
    }
}


@Preview
@Composable
fun SquareButtonWithIconPreView() {
    LeadsTheme {
        SquareButtonWithIcon(icon = R.drawable.user_plus) {

        }
    }
}