package com.example.retrofitrecyclerview

import com.example.retrofitrecyclerview.models.Products
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    fun getAllProducts(): Call<List<Products>>

}