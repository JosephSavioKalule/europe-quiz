package com.mufradat.europequiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mufradat.europequiz.ui.theme.EuropeQuizTheme
import com.mufradat.europequiz.ui.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EuropeQuizTheme {
                NavGraph()
            }
        }
    }
}
