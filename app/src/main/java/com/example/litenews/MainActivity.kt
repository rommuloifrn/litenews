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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.litenews.model.Post
import com.example.litenews.ui.theme.LitenewsTheme
import javax.sql.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LitenewsTheme {
                // A surface container using the 'background' color from the theme
                LiteNewsApp()
            }
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

@Composable
fun LiteNewsApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        PostList(postList = listOf(
            Post(
                R.string.autorDePost1,
                R.string.tituloDePost1,
                R.string.conteudoDePost1
            ),
            Post(
                R.string.autorDePost2,
                R.string.tituloDePost2,
                R.string.conteudoDePost2
            ),
            Post(
                R.string.autorDePost3,
                R.string.tituloDePost3,
                R.string.conteudoDePost3
            ),
        ))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LitenewsTheme {
        Greeting("Android")
    }
}
@Composable
fun PostCard(post: Post, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Text(
                text = LocalContext.current.getString(post.tituloResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = LocalContext.current.getString(post.autorResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
private fun PostCardPreview() {
    PostCard(Post(R.string.autorDePost1, R.string.tituloDePost1, R.string.conteudoDePost1))
}

@Composable
fun PostList(postList: List<Post>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(postList) { post ->
            PostCard(post = post, modifier = Modifier.padding(8.dp))

        }
    }
}