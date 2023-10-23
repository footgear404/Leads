package com.semenchuk.leads.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.semenchuk.leads.ui.theme.LeadsTheme

@Composable
fun LeadStatusBadgeItem(text: String, color: Color, background: Color) {
    Box(
        modifier = Modifier
            .background(background, shape = LeadsTheme.shapes.large)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            lineHeight = 24.sp,
            color = color,
            fontWeight = FontWeight.W700
        )
    }
}