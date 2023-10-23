package com.semenchuk.leads.ui.common_components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.semenchuk.leads.ui.theme.LeadsTheme

@Composable
fun ButtonsRow(
    buttons: List<String>,
    isClicked: (click: Boolean) -> Unit,
) {
    Row {
        buttons.forEach { button ->
            Button(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .weight(1f),
                shape = LeadsTheme.shapes.medium,
                onClick = { isClicked(true) }) {
                Text(
                    modifier = Modifier.padding(
                        horizontal = 16.dp, vertical = 12.dp
                    ), fontSize = 18.sp, text = button
                )
            }
        }
    }
}

@Preview
@Composable
private fun ButtonsRowPreview() {
    LeadsTheme {
        ButtonsRow(listOf("Save", "Cancel"), isClicked = {})
    }
}