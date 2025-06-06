package com.example.litenews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.litenews.model.Post
import com.example.litenews.repository.PostRepository


@Composable
fun MainScreen(navController: NavController, a: String, viewModel: MainScreenViewModel) {

    val state by viewModel.uiState.collectAsState()
    viewModel.getPosts()

    val posts = listOf(
        Post(state.posts,"",""),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
        Post("titulo!", "autor!", "conteudo!!!!"),
    )
    Column {
        Button(
            onClick = {
                viewModel.getPosts()
            },
        ) {
            Text(text = "Carregar")
        }
        PostList(postList = posts, navController = navController)
    }
}

@Composable
fun PostCard(post: Post, modifier: Modifier = Modifier, navController: NavController) {
    Card(modifier = modifier) {
        Column (modifier = Modifier.padding(10.dp)) {
            Text(
                text = post.titulo,
                modifier = Modifier.padding(vertical = 5.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = post.autor,
                modifier = Modifier.padding(vertical = 5.dp),
                style = MaterialTheme.typography.bodySmall
            )
            Button(
                onClick = {
                    navController.navigate("DetailScreen")
                },
                modifier = Modifier.align(alignment = Alignment.End
                )) {
                Text(text = "Ler mais")
            }
        }
    }
}

@Composable
fun PostList(postList: List<Post>, modifier: Modifier = Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {
        items(postList) { post ->
            PostCard(post = post, modifier = Modifier.padding(8.dp), navController = navController)

        }
    }
}