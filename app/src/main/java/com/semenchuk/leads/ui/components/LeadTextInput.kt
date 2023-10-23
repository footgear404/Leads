package com.semenchuk.leads.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.semenchuk.leads.R
import com.semenchuk.leads.ui.theme.LeadsTheme

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
@Preview
@Composable
fun LeadTextInputPreview() {
    LeadsTheme {
        LeadTextInput("test", stringResource(R.string.phone_num_placeholder))
    }
}