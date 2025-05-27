package com.example.litenews.model

import androidx.annotation.StringRes

data class Post(
    @StringRes val autorResourceId: Int,
    @StringRes val tituloResourceId: Int,
    @StringRes val conteudoResourceId: Int

)
