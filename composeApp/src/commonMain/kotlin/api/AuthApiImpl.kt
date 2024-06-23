package api

import client.KtorClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import model.LoginRequest
import model.UserAuthResponse
import util.Constant

class AuthApiImpl : AuthApi {
    override suspend fun login(loginRequest: LoginRequest): UserAuthResponse {
        val response: HttpResponse = KtorClient.client.post("${Constant.BASE_URL}/api/user") {
            contentType(ContentType.Application.Json)
            setBody(
                LoginRequest(
                    username = loginRequest.username,
                    password = loginRequest.password
                )
            )
        }

        return response.body<UserAuthResponse>()
    }
}