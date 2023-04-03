package com.example.hom24mon5

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hom24mon5.remote.LoveModel
import com.example.hom24mon5.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val mutableLiveData = MutableLiveData<LoveModel>()
        LoveService().api.getPercentage(firstName, secondName).enqueue(object :
            Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if(response.isSuccessful){
                    mutableLiveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("123456", "OnFailure ${t.message}")
            }
        })
        return mutableLiveData
    }


}