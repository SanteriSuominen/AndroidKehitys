package com.example.oppimistehtava2_restapi
import retrofit2.http.GET

interface TodoApiService {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
}