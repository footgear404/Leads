package com.semenchuk.leads.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.semenchuk.leads.R
import com.semenchuk.leads.domain.utils.RouteConstants.ADD_LEAD
import com.semenchuk.leads.ui.theme.LeadsTheme

@Composable
fun TopAppBar(
    buttons: List<Button>,
    navController: NavController?,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 16.dp, end = 8.dp)
            .height(72.dp)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "Leads",
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Bold
        )
        buttons.forEach { button ->
            SquareButtonWithIcon(
                icon = button.type.icon,
                onClick = { route ->
                    navController?.navigate(route)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAppBar() {
    val buttons = listOf<Button>(
        Button(
            type = ButtonType.ROUTE(
                path = ADD_LEAD,
                icon = R.drawable.user_plus
            )
        ),
        Button(
            type = ButtonType.SEARCH(
                icon = R.drawable.search
            )
        ),
    )
    LeadsTheme {
        TopAppBar(buttons, navController = null)
    }
}

sealed class ButtonType(val icon: Int) {
    constructor(path: String?, icon: Int) : this(icon)

    class ROUTE(path: String, icon: Int) : ButtonType(path, icon)
    class SEARCH(icon: Int) : ButtonType(icon)
    class UPDATE(icon: Int) : ButtonType(icon)
    class EDIT(icon: Int) : ButtonType(icon)
}

data class Button(val type: ButtonType)