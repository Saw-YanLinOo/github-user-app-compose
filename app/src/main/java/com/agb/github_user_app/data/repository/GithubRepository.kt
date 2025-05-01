package com.agb.github_user_app.data.repository

import com.agb.github_user_app.data.model.UserModel
import com.agb.github_user_app.data.network.GithubApi
import javax.inject.Inject

interface GithubRepository {
    suspend fun getUsers(since:Int,perPage:Int): List<UserModel>
    suspend fun getUserDetail(username:String): UserModel
    suspend fun searchUsersByCategory(category: String,page:Int,perPage:Int): List<UserModel>
    }

class GithubRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi
) : GithubRepository {

    override suspend fun getUsers(since:Int,perPage:Int): List<UserModel> =
        githubApi.getUsers(since=since,perPage=perPage)

    override suspend fun getUserDetail(username: String): UserModel =
        githubApi.getUserDetail(username = username)

    override suspend fun searchUsersByCategory(category: String,page:Int,perPage:Int): List<UserModel> {
        val searchResult = githubApi.searchUsers(query = category, page = page, perPage = perPage)
        return searchResult.items.orEmpty()
    }
}