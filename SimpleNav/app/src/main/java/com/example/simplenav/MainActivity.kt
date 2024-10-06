package com.example.simplenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.simplenav.ui.theme.SimpleNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navCont = rememberNavController()
            NavHost(navController = navCont, startDestination = "Start", builder = {
                composable(route = "Start")
                {
                    Start(navCont)
                }
                composable(
                    route = "SecondScreen/{name}",
                    arguments = listOf(navArgument("name") {
                        type = NavType.StringType
                    })
                )
                { backStackentry ->
                    val uname =
                        backStackentry.arguments?.getString("name") // Need to get value from here
                    println(uname)
                    SecondScreen(navCont, uname ?: "No name")
                }
            })
        }
    }


}