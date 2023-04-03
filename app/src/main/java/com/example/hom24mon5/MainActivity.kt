package com.example.hom24mon5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.hom24mon5.databinding.ActivityMainBinding
import com.example.hom24mon5.remote.LoveModel
import com.example.hom24mon5.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var loveModel: LoveModel
    val viewModel: LoveViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClick()
    }

    private fun initClick() {
        with(binding) {
            btnCalculate.setOnClickListener {
                LoveService().api.getPercentage(
                    etFirstName.text.toString(),
                    etSecondName.text.toString(),
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            viewModel.getLiveLoveModel(
                                etFirstName.text.toString(),
                                etSecondName.text.toString()
                            ).observe(this@MainActivity, Observer {
                                Log.e("123456", "onResponse: $it")
                                getData(it)
                            })
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("123456", "onResponse:  ${t.message}")
                    }
                })
            }
        }
    }
    fun getData(data: LoveModel){
        loveModel = data
        val intent = Intent(this@MainActivity, ResultActivity::class.java )
        intent.putExtra("lovemodel", loveModel)
        startActivity(intent)
    }
}