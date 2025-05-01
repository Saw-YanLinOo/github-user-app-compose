package com.agb.github_user_app.presentation.home

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
class HomeViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel(){

    private val _users = MutableStateFlow<List<UserModel>>(listOf())
    val user: StateFlow<List<UserModel>> = _users.asStateFlow()

    init {
        getUsers()
    }

   private fun getUsers() {
      viewModelScope.launch(Dispatchers.IO) {
          try {
              _users.value =   githubRepository.getUsers(since = 0, perPage = 50)
          }catch (e: Exception){
              e.printStackTrace()
          }
      }
    }

    fun getUsersByCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _users.value = githubRepository.searchUsersByCategory("$category in:repositories", page = 1, perPage = 50)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}