package com.example.hom24mon5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hom24mon5.databinding.ActivityResultBinding
import com.example.hom24mon5.remote.LoveModel

lateinit var binding2: ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding2.root)
        setData()
    }

    private fun setData() {
        val loveModel = intent.getSerializableExtra("lovemodel") as? LoveModel
        with(binding2){
            tvFirstName.text = loveModel?.fname.toString()
            tvSecondName.text = loveModel?.sname.toString()
            tvResult.text = "Результат: " + loveModel?.percentage.toString()
        }
    }
}
