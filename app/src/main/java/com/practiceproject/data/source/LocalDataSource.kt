package com.practiceproject.data.source

import com.practiceproject.data.db.TodoTB
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun addTodo(todoTB: TodoTB)
    fun getTodo(): Flow<List<TodoTB>>
}