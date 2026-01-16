package com.practiceproject.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class TodoTB(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var title:String?,
    var description:String? = null
)