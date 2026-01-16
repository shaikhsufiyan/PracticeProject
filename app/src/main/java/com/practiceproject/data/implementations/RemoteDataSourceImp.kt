package com.practiceproject.data.implementations

import com.practiceproject.data.network.APIInterface
import com.practiceproject.data.network.model.ModelTodoResponse
import com.practiceproject.data.source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImp(
    var apiInterface: APIInterface
) : RemoteDataSource {

    override fun getTodo(): Flow<List<ModelTodoResponse>> = flow {
        emit(apiInterface.getTodo())
    }
}