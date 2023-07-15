package com.tharunbalaji.mvvm_room_retrofit.api

import com.tharunbalaji.mvvm_room_retrofit.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>
}

/*
QuoteService Interface tells the API endpoints to hit
(also includes parameter, responses type)
 */