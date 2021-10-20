package com.example.ecommerceapp.ui.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceapp.R
import com.example.ecommerceapp.data.appmodel.dataclass.LandingScreenListItem
import com.example.ecommerceapp.databinding.ActivityMainBinding
import com.example.ecommerceapp.utils.Resource
import com.example.ecommerceapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ProductDetailInteraction {
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        setUpObservers()
    }

    private fun setUpObservers() {
        homeViewModel.getLandingScreen.observe(this, Observer {

            when (it.status) {

                Resource.Status.SUCCESS -> {
                    val prizeProductsAdapter = ProductListAdapter(
                        it.data!!, this, this
                    )
                    mainBinding.productRecyclerView.layoutManager =
                        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                    mainBinding.productRecyclerView.adapter = prizeProductsAdapter
                }
                Resource.Status.ERROR -> {

                }

            }
        })
    }

    override fun onProductDetailSelected(position: Int, products: LandingScreenListItem) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("product", products)
        startActivity(intent)
    }
}