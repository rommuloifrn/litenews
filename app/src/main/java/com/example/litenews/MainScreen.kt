package com.example.litenews

import androidx.compose.runtime.Composable
import com.example.litenews.model.Post


@Composable
fun MainScreen() {
    val posts = listOf(
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
    )

    PostList(postList = posts)
}