package com.practiceproject.di

import androidx.lifecycle.ViewModelProvider
import com.practiceproject.data.implementations.DataProvideRepoImp
import com.practiceproject.data.db.TodoDAO
import com.practiceproject.data.db.TodoDB
import com.practiceproject.data.implementations.LocalDataSourceImp
import com.practiceproject.data.implementations.NetworkHelperImp
import com.practiceproject.data.implementations.RemoteDataSourceImp
import com.practiceproject.data.network.APIClient
import com.practiceproject.data.source.LocalDataSource
import com.practiceproject.data.source.NetworkHelper
import com.practiceproject.data.source.RemoteDataSource
import com.practiceproject.domain.DataProviderRepo
import com.practiceproject.domain.usecase.AddTodoUseCase
import com.practiceproject.domain.usecase.GetTodoUseCase
import com.practiceproject.presentation.viewmodel.TodoVM
import com.practiceproject.presentation.viewmodel.TodoVMFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
//    val dao: TodoDAO? = TodoDB.getInstance(this@MainActivity)?.todo()
//    val repo = DataProvideRepoImp(dao!!)
//    val addUseCase = AddTodoUseCase(repo)
//    val getUseCase = GetTodoUseCase(repo)
//    val todoVM = ViewModelProvider(this, factory)[TodoVM::class.java]

    //provide todoDB
    single {
        TodoDB.getInstance(androidContext())
    }
    //provide retrofit
    single {
        APIClient.retrofit
    }
    //provides apiInterface
    single {
        APIClient.apiInterface
    }
    single { get<TodoDB>().todo() } // provide dao

    single<LocalDataSource> {
        LocalDataSourceImp(get())
    }

    single<RemoteDataSource> {
        RemoteDataSourceImp(get())
    }

    single<NetworkHelper> {
        NetworkHelperImp(get())
    }

    single<DataProviderRepo> { DataProvideRepoImp(get(), get(), get()) }
    factory {
        AddTodoUseCase(get())
    }
    factory {
        GetTodoUseCase(get())
    }

    viewModel { TodoVM(get(), get()) }
}