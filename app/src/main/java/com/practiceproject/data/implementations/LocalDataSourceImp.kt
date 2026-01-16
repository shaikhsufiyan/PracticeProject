package com.practiceproject.data.implementations

import com.practiceproject.data.db.TodoDAO
import com.practiceproject.data.db.TodoTB
import com.practiceproject.data.source.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImp(var todoDAO: TodoDAO) : LocalDataSource {

    override suspend fun addTodo(todoTB: TodoTB) {
        todoDAO.addTodo(todoTB)
    }

    override fun getTodo(): Flow<List<TodoTB>> {
        return todoDAO.getTodo()
    }
}