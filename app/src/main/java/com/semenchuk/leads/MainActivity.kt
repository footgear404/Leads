package com.semenchuk.leads

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.semenchuk.leads.presentation.AppEntryPoint
import com.semenchuk.leads.ui.theme.LeadsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeadsTheme {
                AppEntryPoint()
            }
        }
    }
}

