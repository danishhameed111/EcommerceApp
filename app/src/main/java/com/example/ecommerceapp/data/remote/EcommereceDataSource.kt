package com.example.ecommerceapp.data.remote

import javax.inject.Inject

class EcommereceDataSource @Inject constructor(
    private val eCommereceService: EcommereceWebService
) : BaseDataSource() {

    suspend fun getLandingScreen() = getResult { eCommereceService.getLandingScreenInfo() }
}