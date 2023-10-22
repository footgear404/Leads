package com.semenchuk.leads.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomAppNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Calls,
        BottomNavItem.Chat,
        BottomNavItem.Leads,
        BottomNavItem.More
    )

    NavigationBar(
        modifier = Modifier
            .padding(16.dp)
            .height(92.dp)
            .clip(RoundedCornerShape(20.dp)),
        contentColor = Color.Red,
        tonalElevation = 8.dp,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach {
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = it.icon),
                            contentDescription = "icon"
                        )
                    },
                    label = {
                        Text(fontSize = 12.sp, text = it.title)
                    },
                    selected = currentRoute == it.screenRoute,
                    onClick = {
                        navController.navigate(it.screenRoute)
                    }
                )
            }
        }
    }
}