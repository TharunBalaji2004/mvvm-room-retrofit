package com.tharunbalaji.mvvm_room_retrofit.db

import androidx.room.Insert
import androidx.room.Query
import com.tharunbalaji.mvvm_room_retrofit.models.Result

interface QuoteDAO {
    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes(): List<Result>
}

/*
QuoteDAO Interface
- tells the queries and actions to be implemented
*/