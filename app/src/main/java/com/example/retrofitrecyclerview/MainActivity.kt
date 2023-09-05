package com.example.retrofitrecyclerview


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitrecyclerview.databinding.ActivityMainBinding
import com.example.retrofitrecyclerview.models.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.18.123:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)
        api.getAllProducts().enqueue(object : Callback<List<Products>>{
            override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
                Log.d("Exitoso","onResponse: {${response.body()!![0].idProduct}} ")

                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                //Log.d("Falla","onFailure")
                Log.d("MainActivity","onFailure: " + t.message)
            }

        })
    }

    private fun showData(produts: List<Products>){

        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ProductAdapter(produts)
        }
    }
}