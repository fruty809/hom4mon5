package com.example.hom24mon5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hom24mon5.remote.LoveModel

class LoveViewModel : ViewModel() {

    private val repository = Repository()

    fun getLiveLoveModel(firstName: String, secondName: String) : LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }
}