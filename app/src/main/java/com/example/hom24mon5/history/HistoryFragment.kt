package com.example.hom24mon5.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hom24mon5.App
import com.example.hom24mon5.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    lateinit var binding: FragmentHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        historyAdapter = HistoryAdapter()
    }

    private fun initViews() {
        binding.rvHistory.layoutManager = LinearLayoutManager(context)
        binding.rvHistory.adapter = historyAdapter
        getDataFromDB()
    }

    private fun getDataFromDB() {
        val listOfLoveModel = App.appDatabase.loveDao().getAllLoveModelByAlphabetAZ()
        historyAdapter.addLoveModelFromRoom(listOfLoveModel)
    }
}