package com.practiceproject.data.network.model

data class ModelTodoResponse(
    val completed: Boolean? =false,
    val id: Int =0,
    val title: String? ="",
    val userId: Int = 0
)