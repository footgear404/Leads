package com.semenchuk.leads.domain.models

data class LeadsPaginated(
    val cursor: String?,
    val data: List<Lead>,
    val hasMore: Boolean,
    val totalCount: Int,
)
