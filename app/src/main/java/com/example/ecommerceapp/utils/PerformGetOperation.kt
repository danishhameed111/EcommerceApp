package com.example.ecommerceapp.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

fun <T, A> performGetOperation(
    saveDataToList: () -> LiveData<T>,
    networkCall: suspend () -> Resource<A>,
    saveCallResult: suspend (A) -> Unit
): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading())
        /*var source = saveDataToList.invoke().map { Resource.success(it) }
        emitSource(source)*/


        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Resource.Status.SUCCESS) {
            saveCallResult(responseStatus.data!!)
            emit(Resource.success(responseStatus.data!! as T))
            //((this as MainActivity).finish())
            /*emit(Resource.success(data = responseStatus.data))
            emitSource(Resource.success(data = responseStatus.data))*/
            //emit(Resource.success(responseStatus))
            /*val source = saveDataToList.invoke().map { Resource.success(it) }
            emitSource(source)*/
            //saveDataToList(responseStatus.data!!)
            //Constants.bannerList?.addAll(responseStatus.data)

        } else if (responseStatus.status == Resource.Status.ERROR) {
            emit(Resource.error(responseStatus.message!!))
            //emitSource(source)
        }
    }