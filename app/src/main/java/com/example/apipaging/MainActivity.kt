package com.example.apipaging

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.example.apipaging.navigation.Screen
import com.example.apipaging.navigation.SetupNavGraph
import com.example.apipaging.screens.SplashScreen
import com.example.apipaging.ui.theme.ApiPagingTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApiPagingTheme {
                val navController = rememberNavController()

                val splashScreenShown = remember { mutableStateOf(true) }

                val navigateToMainScreen = {
                    splashScreenShown.value = false
                }

                if (splashScreenShown.value) {
                    SplashScreen(navigateToMainScreen)
                } else {
                    SetupNavGraph(navController = navController)
                }

            }
        }
    }
}

