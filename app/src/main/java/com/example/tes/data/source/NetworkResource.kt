package com.example.tes.data.source

import com.example.tes.utils.vo.ApiResponse
import com.example.tes.utils.vo.Resource
import kotlinx.coroutines.flow.*
import timber.log.Timber

abstract class NetworkResource  <ResultType,RequestType>{

    private val result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {
                emitAll(loadFromNetwork(apiResponse.data).map{
                    Resource.Success(it)
                })
            }

            is ApiResponse.Error -> {
                emit(Resource.Error<ResultType>(apiResponse.errorMessage))
            }
            else -> {
                Timber.d(apiResponse.toString())
            }
        }
    }


    protected abstract fun loadFromNetwork(data: RequestType): Flow<ResultType>

    protected abstract fun createCall(): Flow<ApiResponse<RequestType>>

    fun asFlow(): Flow<Resource<ResultType>> = result
}