package com.example.financeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.financeapplication.fragments.AddTransactionFragment
import com.example.financeapplication.fragments.ViewTransactionsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var buttonAddTransaction: Button
    private lateinit var buttonViewTransactions: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAddTransaction = findViewById(R.id.button_add_transaction)
        buttonViewTransactions = findViewById(R.id.button_view_transactions)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, AddTransactionFragment())
                .commit()
        }

        buttonAddTransaction.setOnClickListener {
            onClickAddTransaction()
        }

        buttonViewTransactions.setOnClickListener {
            onClickViewTransactions()
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }

    private fun onClickAddTransaction() {
        loadFragment(AddTransactionFragment())
    }

    private fun onClickViewTransactions() {
        loadFragment(ViewTransactionsFragment())
    }
}
