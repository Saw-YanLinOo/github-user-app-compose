package com.agb.github_user_app.data.network

import com.agb.github_user_app.data.model.UserModel
import com.agb.github_user_app.data.network.dto.SearchUserDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET(ENDPOINT_GET_USERS)
    suspend fun getUsers(
        @Query("since") since: Int = 0,
        @Query("per_page") perPage: Int = 50
    ): List<UserModel>

    @GET(ENDPOINT_SEARCH_USERS)
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int =1,
        @Query("per_page") perPage: Int = 50
    ): SearchUserDto

    @GET("$ENDPOINT_GET_USERS/{username}")
   suspend fun getUserDetail(
        @Path("username") username: String
    ): UserModel
}