package com.semenchuk.leads.ui.components

sealed class NavItem(
    val title: String,
    val route: String,
) {
    object Lead : NavItem(
        title = "Leads",
        route = "leads"
    )
    object LeadAdd : NavItem(
        title = "Create lead",
        route = "lead_add"
    )
}