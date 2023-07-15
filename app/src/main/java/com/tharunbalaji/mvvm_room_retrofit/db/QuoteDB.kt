package com.tharunbalaji.mvvm_room_retrofit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Result::class], version = 1)
abstract class QuoteDB: RoomDatabase() {

    abstract fun quoteDao(): QuoteDAO

    companion object {
        @Volatile
        private var INSTANCE: QuoteDB? = null

        fun getDatabase(context: Context): QuoteDB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context,
                        QuoteDB::class.java,
                        "quoteDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}

/*
QuoteDB class helps to create Database
*/