package com.example.litenews

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen() {
    Column {
        Text(text = "Titulo do post")
        Text(text = "Autor do post")
        Text(text = "Conteudo do post")
    }
}