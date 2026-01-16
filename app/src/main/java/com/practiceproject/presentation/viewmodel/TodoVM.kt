    package com.practiceproject.presentation.viewmodel

    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.practiceproject.domain.entity.EntityTodo
    import com.practiceproject.domain.usecase.AddTodoUseCase
    import com.practiceproject.domain.usecase.GetTodoUseCase
    import kotlinx.coroutines.flow.Flow
    import kotlinx.coroutines.flow.MutableStateFlow
    import kotlinx.coroutines.flow.SharingStarted
    import kotlinx.coroutines.flow.StateFlow
    import kotlinx.coroutines.flow.stateIn
    import kotlinx.coroutines.launch
    import kotlin.jvm.Throws

    class TodoVM(
        var addTodo: AddTodoUseCase,
        var getTodo: GetTodoUseCase
    ) : ViewModel() {

        private var _todo = MutableStateFlow<List<EntityTodo>>(
            emptyList()
        )
    //    val todo: StateFlow<List<EntityTodo>> = _todo
        val todo: StateFlow<List<EntityTodo>> =
            getTodo.getTodo().stateIn(viewModelScope, SharingStarted.Lazily, initialValue = emptyList())

    //    fun loadTodo() {
    //        viewModelScope.launch {
    //            getTodo.getTodo().collect {
    //                _todo.value = it
    //            }
    //        }
    //    }

        fun addTodo(title: String) {
            viewModelScope.launch {
                try{
                    addTodo.addTodo(EntityTodo(title = title))

                }catch (e: Exception){
                }
            }
        }
    }