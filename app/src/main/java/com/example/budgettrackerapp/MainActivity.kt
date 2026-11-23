package com.example.budgettrackerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val fab = findViewById<ExtendedFloatingActionButton>(R.id.fab_add)

        if (savedInstanceState == null) show(HomeFragment())

        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> show(HomeFragment())
                // R.id.nav_budgets -> show(BudgetsFragment())
                // R.id.nav_transactions -> show(TransactionsFragment())
                // R.id.nav_goals -> show(GoalsFragment())
            }
            true
        }

        fab.setOnClickListener {
            AddTransactionSheet().show(supportFragmentManager, "add_transaction")
        }
    }

    private fun show(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
