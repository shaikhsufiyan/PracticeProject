package com.practiceproject.data.source

import androidx.room.Query
import com.practiceproject.data.db.TodoTB
import com.practiceproject.data.network.model.ModelTodoResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {


    fun getTodo(): Flow<List<ModelTodoResponse>>
}