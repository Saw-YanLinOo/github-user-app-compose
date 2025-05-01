package com.agb.github_user_app.data.network.dto

import com.agb.github_user_app.data.model.UserModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchUserDto (
    @SerialName("total_count")
    val totalCount: Long? = null,

    @SerialName("incomplete_results")
    val incompleteResults: Boolean? = null,

    @SerialName("items")
    val items: List<UserModel>? = null
)