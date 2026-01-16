package com.practiceproject.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoTB::class], version = 1)
abstract class TodoDB(): RoomDatabase() {
    abstract fun todo(): TodoDAO

    companion object {
        private var instance: TodoDB? = null
        fun getInstance(context: Context): TodoDB? {
            instance = Room.databaseBuilder(
                context = context.applicationContext,
                TodoDB::class.java, "todo_db"
            ).build()

            return instance
        }
    }

}