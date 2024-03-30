package com.example.financeapplication.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.financeapplication.Transaction
import com.example.financeapplication.db.AppDatabase
import com.example.financeapplication.db.TransactionDao
import java.util.concurrent.Executors

class TransactionRepository private constructor(context: Context) {

    private val database: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "app_database"
    ).build()

    private val transactionDao = database.transactionDao()

    private val executor = Executors.newSingleThreadExecutor()

    fun addTransaction(transaction: Transaction) {
        executor.execute {
            transactionDao.insertTransaction(transaction)
        }
    }

    fun updateTransaction(transaction: Transaction) {
        executor.execute {
            transactionDao.updateTransaction(transaction)
        }
    }

    fun deleteTransaction(transaction: Transaction) {
        executor.execute {
            transactionDao.deleteTransaction(transaction)
        }
    }

    fun getAllTransactions(): LiveData<List<Transaction>> = transactionDao.getAllTransactions()

    fun getTransaction(id: Int): LiveData<Transaction> = transactionDao.getTransaction(id)

    companion object {
        private var INSTANCE: TransactionRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TransactionRepository(context)
            }
        }
        fun get(): TransactionRepository {
            return INSTANCE ?: throw IllegalStateException("TransactionRepository must be initialized!")
        }
    }
}
