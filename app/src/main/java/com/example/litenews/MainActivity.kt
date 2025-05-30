package com.example.litenews

import Datasource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.litenews.model.Post
import com.example.litenews.ui.theme.LitenewsTheme
import javax.sql.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "MainScreen", builder = {
                composable("MainScreen") {
                    MainScreen(navController)
                }
                composable("DetailScreen") {
                    DetailScreen()
                }
            })
            //LitenewsTheme {
            //    // A surface container using the 'background' color from the theme
            //    LiteNewsApp()
            //}
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LitenewsTheme {
        Greeting("Android")
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