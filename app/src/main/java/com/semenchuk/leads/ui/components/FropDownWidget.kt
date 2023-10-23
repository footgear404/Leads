package com.semenchuk.leads.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.semenchuk.leads.R
import com.semenchuk.leads.domain.models.DropDownWidgetType
import com.semenchuk.leads.ui.theme.LeadsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownWidget(fieldHint: String, selectableItems: List<DropDownWidgetType>) {
    val selectedItem = remember { mutableStateOf(Pair(-1, "Select")) }
    val isExpanded = remember { mutableStateOf(false) }

    Text(
        text = fieldHint, style = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight.W500,
            color = Color(0xFF000000),
            letterSpacing = 0.5.sp,
        )
    )

    ExposedDropdownMenuBox(
        expanded = isExpanded.value,
        onExpandedChange = { isExpanded.value = it }) {
        OutlinedTextField(
            singleLine = true,
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            value = selectedItem.value.second,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded.value)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .menuAnchor(),
            shape = LeadsTheme.shapes.medium
        )

        DropdownMenu(
            modifier = Modifier
                .height(224.dp)
                .padding(horizontal = 8.dp)
                .clip(LeadsTheme.shapes.medium)
                .background(Color.White, shape = LeadsTheme.shapes.medium)
                .fillMaxWidth(),
            expanded = isExpanded.value,
            onDismissRequest = { isExpanded.value = false }) {
            selectableItems.forEach {

                DropdownMenuItem(
                    text = { Text(text = it.title) },
                    onClick = {
                        selectedItem.value = Pair(it.id, it.title)
                        isExpanded.value = false
                    })
            }
        }
    }
}

@Preview
@Composable
fun DropdownWidgetPreview() {
    LeadsTheme {
        DropdownWidget("Test", listOf())
    }
}