package com.example.litenews

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.litenews.model.Post


@Composable
fun MainScreen(navController: NavController) {
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

    PostList(postList = posts, navController = navController)
}