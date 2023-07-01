package com.tecsup.tecsupapp.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface TecsupAPI {

    // https://reqres.in/api/login
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

    // https://reqres.in/api/users?page=2&limit=100
    @GET("users")
    fun listUser(@Query("page") page: Int, @Query("limit") limit: Int): Single<List<LoginResponse>>

    // https://reqres.in/api/users/2
    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Single<LoginResponse>

    //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=df7c3d67cd1f4066af61c2b9c522db30

    @GET("v2/top-headlines")
    fun listNoticias(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String)  : Single<NoticiasResponse>





}