package com.tecsup.tecsupapp.login

import com.tecsup.tecsupapp.network.ApiService
import com.tecsup.tecsupapp.network.LoginRequest
import com.tecsup.tecsupapp.network.LoginResponse
import io.reactivex.rxjava3.core.Single

class LoginRepository {

        private val api = ApiService().apiService

        fun login(email: String, pass: String): Single<LoginResponse> {
            return api.login(LoginRequest(email, pass))
        }

}