package com.example.ecommerceapp.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.ecommerceapp.data.repository.LandingScreenRepository

class HomeViewModel @ViewModelInject constructor(
    private val landingScreenRepository: LandingScreenRepository
):ViewModel() {
    val getLandingScreen = landingScreenRepository.getLandingScreenInfo()
}