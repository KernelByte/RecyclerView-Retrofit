package com.example.retrofitrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitrecyclerview.databinding.ProductRowBinding
import com.example.retrofitrecyclerview.models.Products


class ProductAdapter(private val products: List<Products>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ProductRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val products: Products = products[position]
        holder.bind(products)
    }

    override fun getItemCount(): Int = products.size

    class ViewHolder(private val itemBinding: ProductRowBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(products: Products) {
            itemBinding.idProductTv.text = products.idProduct.toString()
            itemBinding.quantityTv.text = products.quantity.toString()
        }
    }
}