package com.example.litenews.repository

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


class PostRepository {

    // Function that makes the network request, blocking the current thread
    fun getPosts(): String {
        val pagina = 1
        val porPagina = 10
        val estrategia = "relevant"
        val url = "https://www.tabnews.com.br/api/v1/contents?page=$pagina&per_page=$porPagina&strategy=$estrategia"
        val client = OkHttpClient()

        val request: Request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response: Response -> // https://stackoverflow.com/questions/26969800/try-with-resources-in-kotlin
            return response.body!!.string()
        }
    }
}