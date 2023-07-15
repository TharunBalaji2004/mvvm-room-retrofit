package com.tharunbalaji.mvvm_room_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tharunbalaji.mvvm_room_retrofit.adapters.QuotesRecyclerViewAdapter
import com.tharunbalaji.mvvm_room_retrofit.databinding.ActivityMainBinding
import com.tharunbalaji.mvvm_room_retrofit.viewmodels.MainViewModel
import com.tharunbalaji.mvvm_room_retrofit.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var rvQuotesAdapter: QuotesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = (application as MainApplication).quoteRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        binding.mainViewModel = mainViewModel
        binding.rvQuotes.layoutManager = LinearLayoutManager(this)

        mainViewModel.quotes.observe(this) {
            rvQuotesAdapter = QuotesRecyclerViewAdapter(it.results)
            binding.rvQuotes.adapter = rvQuotesAdapter

            Log.d("QUOTES", it.results.toString())
        }
    }

}