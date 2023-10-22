package com.semenchuk.leads.ui.screens.leads

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.semenchuk.leads.R
import com.semenchuk.leads.ui.components.NavItem
import com.semenchuk.leads.ui.theme.LeadsTheme
import com.semenchuk.leads.ui.utils.FakeItem
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateLeadScreen(
    title: String,
    navController: NavController,
    viewModel: LeadScreenViewModel = koinViewModel(),
) {
    val items = listOf(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5"
    )
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        item { LeadTextInput("First name", "John") }
        item { LeadTextInput("Last name", "Doe") }
        item { DropdownWidget(fieldHint = "Lead intention", selectableItems = items) }
        item { DropdownWidget(fieldHint = "AD Source", selectableItems = items) }
        item { DropdownWidget(fieldHint = "Country", selectableItems = items) }
        item { DropdownWidget(fieldHint = "Language", selectableItems = items) }
        item { LeadTextInput("Phone number", "+998 97 344 66 77") }
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun DropdownWidget(fieldHint: String, selectableItems: List<String>) {
    val selectedItem = remember { mutableStateOf("Select") }
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
            value = selectedItem.value,
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
                    text = { Text(text = it) },
                    onClick = {
                        selectedItem.value = it
                        isExpanded.value = false
                    })
            }

        }
    }
}

//@Preview
//@Composable
//fun DropdownListExamplePreview() {
//    DropdownListExample()
//}

@Composable
fun LeadTextInput(fieldHint: String, placeholder: String) {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        var text by remember { mutableStateOf("") }

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

        TextField(
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp, color = Color(0xFFEEEEEE), shape = LeadsTheme.shapes.medium
                ),
            shape = LeadsTheme.shapes.medium,
            value = text,
            onValueChange = {
                text = it
            },
            placeholder = { Text(text = stringResource(R.string.ex, placeholder)) },
            colors = TextFieldDefaults.colors(
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CreateLeadScreenPreview() {
    LeadsTheme {
        CreateLeadScreen(
            title = NavItem.LeadAdd.title,
            viewModel = FakeItem.fakeLeadScreenViewModel,
            navController = FakeItem.fakeNavController(LocalContext.current)
        )
    }
}