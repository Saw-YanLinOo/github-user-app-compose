package com.agb.github_user_app.presentation.detail


import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agb.github_user_app.data.model.UserModel
import com.agb.github_user_app.data.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val githubRepository: GithubRepository,
   private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _users = MutableStateFlow<UserModel?>(null)
    val user: StateFlow<UserModel?> = _users.asStateFlow()

    init {
        val userName: String? = checkNotNull(savedStateHandle["login"])
        Log.d("DetailViewModel", "userName: $userName")
        getUserDetail(userName ?:"torvalds")
    }

     fun getUserDetail(userName:String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _users.value = githubRepository.getUserDetail(username = userName)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}