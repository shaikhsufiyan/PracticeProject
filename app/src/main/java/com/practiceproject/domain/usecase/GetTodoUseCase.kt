package com.practiceproject.domain.usecase

import com.practiceproject.domain.DataProviderRepo
import com.practiceproject.domain.entity.EntityTodo
import kotlinx.coroutines.flow.Flow

class GetTodoUseCase(var dataProvider: DataProviderRepo) {

    fun getTodo(): Flow<List<EntityTodo>> {
        return dataProvider.getTodo()
    }

    fun test_1(){

    }
}