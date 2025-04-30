package com.agb.github_user_app.data.model

data class User(
    val id: Int = 0, // Default UUID?
    val username: String,
    val name: String,
    val avatarUrl: String,
    val role: String = "Developer", // Default role
    val followers: Int = 12, // Default followers count
    val following: Int = 5, // Default following count
)

val sampleUsers = listOf(
    User(
        id = 1,
        username = "mojombo",
        name = "Tom Preston-Werner",
        avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"
    ),
    User(
        id = 2,
        username = "sawyanlinoo",
        name = "Saw Yan Lin Oo",
        avatarUrl = "https://avatars.githubusercontent.com/u/63788675?v=4"
    ),
    User(
        id = 3,
        username = "defunkt",
        name = "Chris Wanstrath",
        avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4"
    ),
    User(
        id = 4,
        username = "wycats",
        name = "Yehuda Katz",
        avatarUrl = "https://avatars.githubusercontent.com/u/4?v=4"
    ),
    User(
        id = 5,
        username = "pjhyett",
        name = "PJ Hyett",
        avatarUrl = "https://avatars.githubusercontent.com/u/3?v=4"
    ),
    User(
        id = 6,
        username = "gaearon",
        name = "Dan Abramov",
        avatarUrl = "https://avatars.githubusercontent.com/u/810438?v=4",
        role = "React Core Team",
        followers = 100,
        following = 40
    )
)

