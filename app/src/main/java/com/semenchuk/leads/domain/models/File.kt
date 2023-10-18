package com.semenchuk.leads.domain.models

data class File(
    val id: Int,
    val mimeType: String,
    val name: String,
    val path: String,
    val size: Int,
    val thumbnail: String,
)
