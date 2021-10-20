package com.example.ecommerceapp.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ecommerceapp.data.appmodel.dataclass.LandingScreenList
import javax.inject.Inject

class Constants @Inject constructor() {
    companion object{
        var BASEURL="https://fakestoreapi.com/"
        var landingScreenList: LiveData<LandingScreenList>? = MutableLiveData()
    }
}