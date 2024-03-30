package com.example.financeapplication.viewModel

import androidx.lifecycle.ViewModel
import com.example.financeapplication.repository.TransactionRepository

class TransactionViewModel() : ViewModel() {
    private val transactionRepository = TransactionRepository.get()
    val transactions = transactionRepository.getAllTransactions()
}