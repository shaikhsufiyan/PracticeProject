package com.practiceproject.data.implementations

import com.practiceproject.data.db.TodoDAO
import com.practiceproject.data.network.APIInterface
import com.practiceproject.data.source.LocalDataSource
import com.practiceproject.data.source.NetworkHelper
import com.practiceproject.data.source.RemoteDataSource
import com.practiceproject.data.toDTO
import com.practiceproject.data.toDomain
import com.practiceproject.domain.DataProviderRepo
import com.practiceproject.domain.entity.EntityTodo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataProvideRepoImp(
    var localDataSource: LocalDataSource,
    var remoteDataSource: RemoteDataSource,
    var networkHelper: NetworkHelper
) : DataProviderRepo {


    override suspend fun addTodo(todoTB: EntityTodo) {
        localDataSource.addTodo(todoTB.toDTO())
    }

    override fun getTodo(): Flow<List<EntityTodo>> {
        return if (networkHelper.isNetworkAvailable()) {
            remoteDataSource.getTodo().map { it -> it.map { it.toDomain() } }
        } else {
            localDataSource.getTodo().map { it -> it.map { it.toDomain() } }
        }
    }
}