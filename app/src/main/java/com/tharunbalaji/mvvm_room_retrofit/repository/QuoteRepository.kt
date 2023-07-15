package com.tharunbalaji.mvvm_room_retrofit.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tharunbalaji.mvvm_room_retrofit.api.QuoteService
import com.tharunbalaji.mvvm_room_retrofit.models.QuoteList
import com.tharunbalaji.mvvm_room_retrofit.utils.NetworkFinder

class QuoteRepository(private val quoteService: QuoteService, private val applicationContext: Context) {

    private val quotesLiveData = MutableLiveData<Response<QuoteList>>()
    val quotes: LiveData<Response<QuoteList>> = quotesLiveData

    suspend fun getQuotes(page: Int) {
        if (NetworkFinder.isInternetAvailable(applicationContext)) {
            val result = quoteService.getQuotes(page = page)

            if (result.body() != null) {
                quotesLiveData.postValue(Response.Success(result.body()!!))
            }
        } else {
                quotesLiveData.postValue(Response.Error("Network Unavailable"))
        }
    }

}