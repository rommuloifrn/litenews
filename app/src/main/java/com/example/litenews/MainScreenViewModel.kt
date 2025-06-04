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

class MainScreenViewModel (private val pr: PostRepository): ViewModel() {

    private val _uiState = MutableStateFlow(PostsUiState())
    val uiState: StateFlow<PostsUiState> = _uiState.asStateFlow()
    fun getPosts() {

        viewModelScope.launch (Dispatchers.IO) {
            _uiState.update {currentState ->
                currentState.copy(posts = pr.getPosts())
            } // assincrono
        } // viewmodel (https://developer.android.com/topic/libraries/architecture/viewmodel)
    }
}