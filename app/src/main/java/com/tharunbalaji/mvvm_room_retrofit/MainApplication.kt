package com.tharunbalaji.mvvm_room_retrofit

import android.app.Application
import com.tharunbalaji.mvvm_room_retrofit.api.QuoteService
import com.tharunbalaji.mvvm_room_retrofit.api.RetrofitHelper
import com.tharunbalaji.mvvm_room_retrofit.repository.QuoteRepository

class MainApplication: Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialise()
    }

    private fun initialise() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        quoteRepository = QuoteRepository(quoteService)
    }

}