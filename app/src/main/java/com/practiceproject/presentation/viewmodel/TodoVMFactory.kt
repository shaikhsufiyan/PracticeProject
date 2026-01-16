package com.practiceproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practiceproject.domain.usecase.AddTodoUseCase
import com.practiceproject.domain.usecase.GetTodoUseCase

class TodoVMFactory(
    var addTodo: AddTodoUseCase,
    var getTodo: GetTodoUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoVM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TodoVM(addTodo, getTodo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}