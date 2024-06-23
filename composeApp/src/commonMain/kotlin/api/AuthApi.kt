package api

import model.LoginRequest
import model.UserAuthResponse

interface AuthApi {

    suspend fun login(loginRequest: LoginRequest): UserAuthResponse

}