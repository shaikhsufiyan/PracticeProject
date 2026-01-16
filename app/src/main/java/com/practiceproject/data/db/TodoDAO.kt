package com.practiceproject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface TodoDAO {

    @Insert
    suspend fun addTodo(todoTB: TodoTB)

    @Query("Select * from todo")
    fun getTodo(): Flow<List<TodoTB>>


}