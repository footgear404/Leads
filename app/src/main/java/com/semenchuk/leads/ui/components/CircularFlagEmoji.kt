package com.semenchuk.leads.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularFlagEmoji(modifier: Modifier, emoji: String) {
    Canvas(
        modifier = modifier
    ) {

        val textWidth = this.size.width
        val textHeight = this.size.height

        drawCircle(color = Color.Gray)

        val textPadding = 0.dp
        val horizontalCenter = (this.center.x - textWidth / 2).toInt()
        val verticalCenter = (this.center.y - textHeight / 2 - textPadding.toPx()).toInt()

        drawContext.canvas.nativeCanvas.drawText(
            emoji,
            horizontalCenter.toFloat() - 10,
            verticalCenter.toFloat() + 40,

            Paint().asFrameworkPaint().apply {
                textSize = 20.sp.toPx()
                color = Color.White.toArgb()
            }
        )
    }
}

@Preview
@Composable
private fun CircularFlagEmojiPreview() {
    CircularFlagEmoji(
        modifier = Modifier
            .background(Color.Gray, shape = CircleShape)
            .size(16.dp)
            .clip(shape = CircleShape),
        emoji = "🇺🇸",
    )
}