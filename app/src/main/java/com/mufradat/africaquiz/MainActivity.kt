package com.mufradat.africaquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mufradat.africaquiz.ui.theme.AfricaQuizTheme
import com.mufradat.africaquiz.ui.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AfricaQuizTheme {
                NavGraph()
            }
        }
    }
}
