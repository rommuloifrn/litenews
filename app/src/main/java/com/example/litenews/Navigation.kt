package com.example.litenews

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.litenews.model.Post

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.PostListScreen.route
    ) {
        composable(route = Screen.PostListScreen.route) {
            PostList(
                postList = listOf(
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
                    Post(
                        R.string.autorDePost4,
                        R.string.tituloDePost4,
                        R.string.conteudoDePost4
                    ),
                    Post(
                        R.string.autorDePost5,
                        R.string.tituloDePost5,
                        R.string.conteudoDePost5
                    ),
                ),
                navController = navController
            )
        }

        composable(
            route = Screen.ReadPostScreen.route + "/{tituloResourceId}/{autorResourceId}/{conteudoResourceId}",
            arguments = listOf(
                navArgument("tituloResourceId") {
                    type = NavType.IntType
                },
                navArgument("autorResourceId") {
                    type = NavType.IntType
                },
                navArgument("conteudoResourceId") {
                    type = NavType.IntType
                }

            )
        ) { entry ->
            ReadPost(
                tituloResourceId = entry.arguments?.getInt("tituloResourceId"),
                autorResourceId = entry.arguments?.getInt("autorResourceId"),
                conteudoResourceId = entry.arguments?.getInt("conteudoResourceId")
            )
        }
    }
}