package com.example.ecofarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ecofarm.ui.theme.EcoFarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoFarmTheme {
                Navigation() // A navegação agora é feita através da função de Navigation.kt
            }
        }
    }
}
