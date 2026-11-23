package com.example.budgettrackerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.rv_categories).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CategoryAdapter(SampleData.categories)
        }
        view.findViewById<RecyclerView>(R.id.rv_transactions).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = TransactionAdapter(SampleData.transactions)
        }
    }
}
