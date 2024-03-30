package com.example.financeapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var amount: Double,
    var category: String,
    var date: String
)
