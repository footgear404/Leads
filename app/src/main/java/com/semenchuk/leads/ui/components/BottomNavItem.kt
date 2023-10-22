package com.semenchuk.leads.ui.components

import com.semenchuk.leads.R

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var screenRoute: String,
) {

    object Home : BottomNavItem("Home", R.drawable.home_ico, "home")
    object Calls : BottomNavItem("Calls", R.drawable.calls_ico, "calls")
    object Chat : BottomNavItem("Chat", R.drawable.chat_ico, "chat")
    object Leads : BottomNavItem("Leads", R.drawable.leads_ico, "leads")
    object More : BottomNavItem("More", R.drawable.more_ico, "more")

}