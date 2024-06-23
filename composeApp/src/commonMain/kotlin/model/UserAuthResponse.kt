package model

import kotlinx.serialization.Serializable

@Serializable
data class UserAuthResponse(
    val id: String? = null,
    val username: String? = null,
    val accessToken: String,
    val refreshToken : String
)
