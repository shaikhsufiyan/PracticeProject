package com.practiceproject.domain

import com.practiceproject.domain.entity.EntityTodo
import kotlinx.coroutines.flow.Flow

interface DataProviderRepo {

    suspend fun addTodo(todoTB: EntityTodo)
    fun getTodo(): Flow<List<EntityTodo>>
}