package com.example.ecommerceapp.di

import com.example.ecommerceapp.data.remote.EcommereceDataSource
import com.example.ecommerceapp.data.remote.EcommereceWebService
import com.example.ecommerceapp.data.repository.LandingScreenRepository
import com.example.ecommerceapp.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASEURL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideEBigWinService(retrofit: Retrofit): EcommereceWebService = retrofit.create(EcommereceWebService::class.java)

    @Singleton
    @Provides
    fun provideEbigWinDataSource(ecommereceWebService: EcommereceWebService) = EcommereceDataSource(ecommereceWebService)


    @Singleton
    @Provides
    fun provideAppLandingScreenRepository(eBigWinDataSource: EcommereceDataSource
        /*localDataSource: CharacterDao*//*, constants : Constants*/) =
        LandingScreenRepository(eBigWinDataSource /*localDataSource*//*, constants*/)

}