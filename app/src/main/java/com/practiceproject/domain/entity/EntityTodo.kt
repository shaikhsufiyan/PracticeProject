package com.practiceproject.domain.entity

data class EntityTodo(
    val id: Int? = null,
    val title: String?,
    val description: String? = null
) {
    fun validateTodo(): Boolean {
        return if (title!!.isEmpty()) false else true
    }

}
