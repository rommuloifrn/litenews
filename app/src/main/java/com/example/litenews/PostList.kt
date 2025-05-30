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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.litenews.model.Post


@Composable
fun PostList(postList: List<Post>, modifier: Modifier = Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {

        items(postList) { post ->
            PostCard(post = post, modifier = Modifier.padding(8.dp), navController = navController)
        }
    }
}

@Composable
fun PostCard(post: Post, modifier: Modifier = Modifier, navController: NavController) {
    Card(modifier = modifier) {
        Column (modifier = Modifier.padding(10.dp)) {
            Text(
                text = LocalContext.current.getString(post.tituloResourceId),
                modifier = Modifier.padding(vertical = 5.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = LocalContext.current.getString(post.autorResourceId),
                modifier = Modifier.padding(vertical = 5.dp),
                style = MaterialTheme.typography.bodySmall
            )
            Button(
                onClick = {
                    navController.navigate(
                        Screen.ReadPostScreen.withArgs(
                            post.tituloResourceId.toString(),
                            post.autorResourceId.toString(),
                            post.conteudoResourceId.toString()
                        )
                    )
                },
                modifier = Modifier.align(alignment = Alignment.End)
            ) {
                Text(text = "Ler mais")
            }
        }
    }
}