package com.example.hom24mon5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.hom24mon5.databinding.ActivityLoveBinding
import com.example.hom24mon5.remote.LoveModel
import com.example.hom24mon5.remote.LoveService
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class LoveActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoveBinding
    lateinit var loveModel: LoveModel
    val viewModel: LoveViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClick()
    }

    private fun initClick() {
        Log.e("shh", "Зашёл")
        with(binding) {
            btnCalculate.setOnClickListener {
                Log.e("shh", "нажал")
                LoveService().api.getPercentage(
                    etFirstName.text.toString(),
                    etSecondName.text.toString(),
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            viewModel.getLiveLoveModel(
                                etFirstName.text.toString(),
                                etSecondName.text.toString()
                            ).observe(this@LoveActivity, Observer {
                                Log.e("shh", "onResponse: $it")
                                getData(it)
                            })
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("shh", "onResponse:  ${t.message}")
                    }
                })
            }
        }
    }
    fun getData(data: LoveModel){
        loveModel = data
        val intent = Intent(this@LoveActivity, ResultFragment::class.java )
        intent.putExtra("lovemodel", loveModel)
        startActivity(intent)
    }
}