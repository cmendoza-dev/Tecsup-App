package com.tecsup.tecsupapp.noticias

import com.tecsup.tecsupapp.network.ApiService
import com.tecsup.tecsupapp.network.NoticiasResponse
import io.reactivex.rxjava3.core.Single

class NoticiasRepository {

    private val api = ApiService().apiService

    fun listNoticias(country: String, category: String, apiKey: String):
            Single<NoticiasResponse>{
        return api.listNoticias(country, category, apiKey)
    }

}