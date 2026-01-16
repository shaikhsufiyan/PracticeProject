package com.practiceproject.data.network

import com.practiceproject.data.network.model.ModelTodoResponse
import com.practiceproject.domain.entity.EntityTodo
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {

    @GET("todos")
    suspend fun getTodo(): List<ModelTodoResponse>
}