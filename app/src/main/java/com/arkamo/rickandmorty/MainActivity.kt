package com.arkamo.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.arkamo.rickandmorty.character.presentation.navigation.CHARACTER_LIST_ROUTE
import com.arkamo.rickandmorty.character.presentation.navigation.characterListScreen
import com.arkamo.rickandmorty.designsystem.theme.RickAndMortyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // RickAndMortyAppTheme provides the custom design-system tokens (colors,
            // typography, dimensions) via CompositionLocal.
            // MaterialTheme wraps all screens so Material3 components resolve their
            // color and typography correctly.
            RickAndMortyAppTheme {
                MaterialTheme {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = CHARACTER_LIST_ROUTE,
                    ) {
                        characterListScreen()
                    }
                }
            }
        }
    }
}
