package com.example.financeapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.financeapplication.Transaction

@Database(entities = [Transaction::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionDao
}
