package com.semenchuk.leads.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.semenchuk.leads.domain.models.Lead
import com.semenchuk.leads.ui.theme.LeadsTheme
import com.semenchuk.leads.ui.utils.FakeItem
import com.semenchuk.leads.ui.utils.color

@Composable
fun LeadListItem(
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
private fun LeadListItemPreview() {
    LeadsTheme {
        LeadListItem(lead = FakeItem.lead)
    }
}