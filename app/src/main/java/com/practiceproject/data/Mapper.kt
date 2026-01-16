package com.practiceproject.data

import com.practiceproject.data.db.TodoTB
import com.practiceproject.data.network.model.ModelTodoResponse
import com.practiceproject.domain.entity.EntityTodo

//dbDTO -> domain(entity)
fun TodoTB.toDomain() = EntityTodo(id, title, description)

//entity(domain) -> todoDB
fun EntityTodo.toDTO() = TodoTB(title = title)

//reponseModel -> Domain
fun ModelTodoResponse.toDomain() = EntityTodo(id, title, description = completed.toString())


fun EntityTodo.toReponseDTO() = ModelTodoResponse(completed = false, id!!, title)