package com.example.hom24mon5.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hom24mon5.databinding.ItemHistoryBinding
import com.example.hom24mon5.remote.LoveModel

class HistoryAdapter() : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private var historyList = arrayListOf<LoveModel>()

    fun addLoveModelFromRoom(list: List<LoveModel>){
        historyList = list as ArrayList<LoveModel>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(historyList[position])
    }

    class HistoryViewHolder(var binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(loveModel: LoveModel){
            with(binding){
                tvFirstNameItem.text = loveModel.fname
                tvSecondNameItem.text = loveModel.sname
                tvPercentageItem.text= loveModel.percentage
            }
        }

    }
}