package com.semenchuk.leads.ui.common_components

import com.semenchuk.leads.R
import com.semenchuk.leads.domain.utils.RouteConstants

sealed class BottomNavItem(
    var title: Int,
    var icon: Int,
    var screenRoute: String,
) {

    object Home : BottomNavItem(R.string.home, R.drawable.home_ico, RouteConstants.HOME)
    object Calls : BottomNavItem(R.string.calls, R.drawable.calls_ico, RouteConstants.CALLS)
    object Chat : BottomNavItem(R.string.chat, R.drawable.chat_ico, RouteConstants.CHAT)
    object Leads : BottomNavItem(R.string.leads, R.drawable.leads_ico, RouteConstants.LEADS)
    object More : BottomNavItem(R.string.more, R.drawable.more_ico, RouteConstants.MORE)

}