package com.practiceproject.domain.usecase

import com.practiceproject.domain.DataProviderRepo
import com.practiceproject.domain.entity.EntityTodo

class AddTodoUseCase(var dataProvider: DataProviderRepo) {

    suspend fun addTodo(todo: EntityTodo) {
        if (todo.validateTodo()) {
            dataProvider.addTodo(todo)
        }else{
            throw Exception("Field cannot be empty")
        }
    }

    suspend fun deleteTodo(){

    }

    suspend fun deleteTodo2(){

    }
}