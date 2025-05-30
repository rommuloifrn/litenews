package com.example.litenews

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.litenews.model.Post

@Composable
fun ReadPost(tituloResourceId: Int?, autorResourceId: Int?, conteudoResourceId: Int?) {
    Column {
        Text(
            text = LocalContext.current.getString(tituloResourceId!!)
        )
        Text(
            text = LocalContext.current.getString(autorResourceId!!)
        )
        Text(
            text = LocalContext.current.getString(conteudoResourceId!!)
        )
    }
}