package com.muindogituku.assignment3

import BeatingHeartAnimation
import EnterExitAnimationScreen
import RocketAnimationScreen
import ScaleAnimationButton
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.muindogituku.assignment3.ui.theme.Assignment3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController() // Remember the NavController

                    // Navigate to the MainLauncherActivity initially
                    NavHost(navController = navController, startDestination = "mainLauncher") {
                        composable("mainLauncher") {
                            MainLauncherActivity(navController = navController)
                        }
                        composable("scaleAnimation") {
                            ScaleAnimationButton(navController = navController)
                        }
                        composable("enterExitAnimation") {
                            EnterExitAnimationScreen(navController = navController)
                        }
                        composable("beatingHeartAnimation") {
                            BeatingHeartAnimation(navController = navController)
                        }
                        composable("rocketAnimation") {
                            RocketAnimationScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLauncherActivity(navController: NavController) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Animations Assignment") },
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("scaleAnimation") }, // Navigate to ScaleAnimationButton
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(text = "Scale Animation")
            }

            Button(
                onClick = { navController.navigate("enterExitAnimation") }, // Navigate to EnterExitAnimationScreen
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(text = "Enter/Exit Animation")
            }

            Button(
                onClick = { navController.navigate("beatingHeartAnimation") }, // Navigate to BeatingHeartAnimation
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(text = "Beating Heart Animation")
            }

            Button(
                onClick = { navController.navigate("rocketAnimation") }, // Navigate to RocketAnimationScreen
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(text = "Rocket Animation")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainLauncherPreview() {
    MaterialTheme {
        MainLauncherActivity(NavController(LocalContext.current))
    }
}
