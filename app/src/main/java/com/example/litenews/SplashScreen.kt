package com.example.litenews

import android.window.SplashScreen
import androidx.annotation.RestrictTo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay

@Composable
 fun SplashScreen(navControler: NavController, viewModel: SplashScreenViewModel) {
    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "litenews", 
            style = MaterialTheme.typography.headlineLarge
        )
        Text(text = "Um client de leitura para o fórum Tabnews")
        Button(onClick = { navControler.navigate("MainScreen") }) {
            Text(text = "Ver posts")
        }

    }

    //viewModel.wait {
    //    navControler.navigate("MainScreen")
    //}

}
