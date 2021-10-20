package com.example.ecommerceapp.ui.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecommerceapp.R
import com.example.ecommerceapp.data.appmodel.dataclass.LandingScreenList
import com.example.ecommerceapp.data.appmodel.dataclass.LandingScreenListItem
import com.example.ecommerceapp.databinding.ActivityMainBinding
import com.example.ecommerceapp.databinding.ActivityProductDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailActivity : AppCompatActivity() {
    private lateinit var productDetailBinding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productDetailBinding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(productDetailBinding.root)
        initUi()
    }

    private fun initUi() {
        val intentData = intent.getParcelableExtra<LandingScreenListItem>("product")
        productDetailBinding.productName.text = intentData?.title
        productDetailBinding.productPrise.text = intentData?.price.toString()
        Picasso.get()
            .load(intentData?.image)
            .placeholder(
                R.drawable.ic_launcher_foreground
            ).into(productDetailBinding.productImage)

    }
}