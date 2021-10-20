package com.example.ecommerceapp.data.remote

import com.example.ecommerceapp.data.appmodel.dataclass.LandingScreenList
import retrofit2.Response
import retrofit2.http.GET

interface EcommereceWebService {
    @GET("products/")
    suspend fun getLandingScreenInfo(): Response<LandingScreenList>
}