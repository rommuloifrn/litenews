package com.example.litenews

sealed class Screen(val route: String) {
    object PostListScreen : Screen("post_list")
    object ReadPostScreen : Screen("read_post")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/${arg}")
            }
        }

    }
}

