package com.example.financeapplication

import android.app.Application
import androidx.room.Room
import com.example.financeapplication.db.AppDatabase
import com.example.financeapplication.repository.TransactionRepository

class FinApp : Application() {

    override fun onCreate() {

        super.onCreate()
        TransactionRepository.initialize(this)
    }
}