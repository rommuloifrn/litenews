package com.example.litenews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.litenews.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class PostsUiState(
    val posts: String = "posts ainda nao carregados"
)

class MainScreenViewModel (): ViewModel() {

    private val _uiState = MutableStateFlow(PostsUiState())
    val uiState: StateFlow<PostsUiState> = _uiState.asStateFlow()
    fun getPosts() {
        viewModelScope.launch {
            val pr: PostRepository = PostRepository()
            _uiState.update {currentState ->
                currentState.copy(posts = "Mudança de estado")//pr.getPosts())

            } // assincrono
        } // viewmodel (https://developer.android.com/topic/libraries/architecture/viewmodel)
    }
}