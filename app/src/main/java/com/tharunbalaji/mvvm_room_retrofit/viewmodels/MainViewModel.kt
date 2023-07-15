package com.tharunbalaji.mvvm_room_retrofit.viewmodels

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tharunbalaji.mvvm_room_retrofit.models.QuoteList
import com.tharunbalaji.mvvm_room_retrofit.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    val quotes: LiveData<QuoteList> = quoteRepository.quotes
    val pageNumber = ObservableField<Int>()
    val pageLoading = ObservableField<Boolean>()

    init {
        pageNumber.set(1)
        fetchQuotes()
    }

    private fun fetchQuotes() {
        val currentPage = pageNumber.get() ?: return
        pageLoading.set(true)
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.getQuotes(page = currentPage)
            pageLoading.set(false)
        }
    }

    fun nextPage() {
        val currentPage = pageNumber.get() ?: return
        pageNumber.set(currentPage.inc())
        fetchQuotes()
    }

    fun prevPage() {
        val currentPage = pageNumber.get() ?: return

        if (currentPage > 1) {
            pageNumber.set(currentPage.dec())
            fetchQuotes()
        }
    }
}