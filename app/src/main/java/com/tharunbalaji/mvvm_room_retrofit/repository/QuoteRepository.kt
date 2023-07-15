package com.tharunbalaji.mvvm_room_retrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tharunbalaji.mvvm_room_retrofit.api.QuoteService
import com.tharunbalaji.mvvm_room_retrofit.models.QuoteList

class QuoteRepository(private val quoteService: QuoteService) {

    private val quotesLiveData = MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList> = quotesLiveData

    suspend fun getQuotes(page: Int) {
        val result = quoteService.getQuotes(page = page)

        if (result.body() != null) {
            quotesLiveData.postValue(result.body()!!)
        }
    }

}