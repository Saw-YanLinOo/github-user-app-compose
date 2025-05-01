package com.agb.github_user_app.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserModel (
    val login: String? = null,
    val id: Long? = null,

    @SerialName("node_id")
    val nodeId: String? = null,

    @SerialName("avatar_url")
    val avatarUrl: String? = null,

    @SerialName("gravatar_id")
    val gravatarId: String? = null,

    val url: String? = null,

    @SerialName("html_url")
    val htmlUrl: String? = null,

    @SerialName("followers_url")
    val followersUrl: String? = null,

    @SerialName("following_url")
    val followingUrl: String? = null,

    @SerialName("gists_url")
    val gistsUrl: String? = null,

    @SerialName("starred_url")
    val starredUrl: String? = null,

    @SerialName("subscriptions_url")
    val subscriptionsUrl: String? = null,

    @SerialName("organizations_url")
    val organizationsUrl: String? = null,

    @SerialName("repos_url")
    val reposUrl: String? = null,

    @SerialName("events_url")
    val eventsUrl: String? = null,

    @SerialName("received_events_url")
    val receivedEventsUrl: String? = null,

    val type: String? = null,

    @SerialName("user_view_type")
    val userViewType: String? = null,

    @SerialName("site_admin")
    val siteAdmin: Boolean? = null,

    val name: String? = null,
    val company: String? = null,
    val blog: String? = null,
    val location: String? = null,
//    val email: String? = null,
//    val hireable: String? = null,
    val bio: String? = null,

    @SerialName("twitter_username")
    val twitterUsername: String? = null,

    @SerialName("public_repos")
    val publicRepos: Long? = null,

    @SerialName("public_gists")
    val publicGists: Long? = null,

    val followers: Long? = null,
    val following: Long? = null,

    @SerialName("created_at")
    val createdAt: String? = null,

    @SerialName("updated_at")
    val updatedAt: String? = null
)

val sampleUsers = listOf(
    UserModel(
        id = 1,
        login = "mojombo",
        avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"
    ),
    UserModel(
        id = 2,
        login = "sawyanlinoo",
        avatarUrl = "https://avatars.githubusercontent.com/u/63788675?v=4"
    ),
    UserModel(
        id = 3,
        login = "defunkt",
        avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4"
    ),
    UserModel(
        id = 4,
        login = "wycats",
        avatarUrl = "https://avatars.githubusercontent.com/u/4?v=4"
    ),
    UserModel(
        id = 5,
        login = "pjhyett",
        avatarUrl = "https://avatars.githubusercontent.com/u/3?v=4"
    ),
    UserModel(
        id = 6,
        login = "gaearon",
        avatarUrl = "https://avatars.githubusercontent.com/u/810438?v=4",
    )
)

