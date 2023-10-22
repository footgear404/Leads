package com.semenchuk.leads.ui.utils

import androidx.compose.ui.graphics.Color


fun Color.fromHex(color: String) = Color(android.graphics.Color.parseColor(color))

fun String.color() = Color(android.graphics.Color.parseColor(this))
