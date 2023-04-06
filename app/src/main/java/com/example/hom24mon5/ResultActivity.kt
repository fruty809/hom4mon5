package com.example.hom24mon5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hom24mon5.databinding.ActivityResultBinding
import com.example.hom24mon5.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
    }

    private fun setData() {
        val loveModel = intent.getSerializableExtra("lovemodel") as? LoveModel
        with(binding){
            tvFirstName.text = loveModel?.fname.toString()
            tvSecondName.text = loveModel?.sname.toString()
            tvResult.text = loveModel?.percentage.toString() + "%"
        }
    }
}