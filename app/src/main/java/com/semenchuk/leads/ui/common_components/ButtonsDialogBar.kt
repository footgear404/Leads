package com.semenchuk.leads.ui.common_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.semenchuk.leads.ui.theme.LeadsTheme

@Composable
fun ButtonsDialogBar(
    isSaveClick: (result: Boolean) -> Unit,
) {
    NavigationBar(
        modifier = Modifier
            .padding(16.dp)
            .height(92.dp)
            .clip(RoundedCornerShape(20.dp)),
        contentColor = Color.Red,
        tonalElevation = 8.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonsRow(listOf("Cancel", "Save"), isSaveClick)
        }
    }
}


@Preview
@Composable
private fun ButtonsDialogBarPreview() {
    LeadsTheme {
        ButtonsDialogBar(isSaveClick = {})
    }
}