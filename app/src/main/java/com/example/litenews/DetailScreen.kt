package com.example.litenews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController) {
    Column (modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Titulo do post",
            fontSize = 37.sp
        )
        Text(
            text = "Autor do post",
            fontSize = 20.sp
        )
        Text(
            text = "Conteudo do post",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        
        Button(onClick = {
            navController.navigate("MainScreen")
        }) {
            Text(text = "Voltar")
        }
    }
}