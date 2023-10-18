package com.semenchuk.leads

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.semenchuk.leads.presentation.App
import com.semenchuk.leads.ui.theme.LeadsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeadsTheme {
                App()
            }
        }
    }
}

