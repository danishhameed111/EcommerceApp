package com.example.ecommerceapp.ui.mainactivity

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.R
import com.example.ecommerceapp.data.appmodel.dataclass.LandingScreenList
import com.example.ecommerceapp.data.appmodel.dataclass.LandingScreenListItem
import com.example.ecommerceapp.databinding.ProductsListingLayoutBinding
import com.squareup.picasso.Picasso


class ProductListAdapter(
    val products: LandingScreenList,
    val productDetailInteraction: ProductDetailInteraction,
    var context: Activity
) : RecyclerView.Adapter<ProductsViewHolder>() {

    lateinit var _binding: ProductsListingLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        _binding = ProductsListingLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductsViewHolder(_binding.root)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {


        //set image
        Picasso.get()
            .load(products.get(position).image)
            .placeholder(
                R.drawable.ic_launcher_foreground
            ).into(_binding.imgProduct)

        _binding.tvProductPrice.text = products.get(position).price.toString()
        _binding.tvProductTitle.text = products.get(position).title
        _binding.mainView.setOnClickListener {
            productDetailInteraction.onProductDetailSelected(
                position, products[position]
            )
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}

interface ProductDetailInteraction {
    fun onProductDetailSelected(position: Int, products: LandingScreenListItem)
}

class ProductsViewHolder(view: View) : RecyclerView.ViewHolder(view)