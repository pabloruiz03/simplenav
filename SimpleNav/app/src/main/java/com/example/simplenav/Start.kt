package com.example.simplenav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.NavController

@Composable
fun Start(navController: NavController) {
    var userName by rememberSaveable { mutableStateOf("How") }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Text(text = "Navigation", Modifier.background(color = Color.Blue))

        TextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Enter UserName") },

            )


        Button(onClick = {


            navController.navigate("SecondScreen/"+userName)
        }) {
            Text(text = "Click here for Second Screen")

        }

        Button(onClick = {}) {
            Text(text = "Click here for Third Screen")

        }
    }
}