package com.example.ecommerceapp.data.repository

import com.example.ecommerceapp.data.remote.EcommereceDataSource
import com.example.ecommerceapp.utils.Constants
import com.example.ecommerceapp.utils.performGetOperation
import javax.inject.Inject

class LandingScreenRepository @Inject constructor(private val ecommereceDataSource: EcommereceDataSource?) {
    fun getLandingScreenInfo() = performGetOperation(
        saveDataToList = { Constants.landingScreenList!! },
        networkCall = { ecommereceDataSource!!.getLandingScreen() },
        saveCallResult = { Constants.landingScreenList?.value }
    )
}