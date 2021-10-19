package com.example.wetherandwind.feature.wind_screen.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.system.Os.bind
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.wetherandwind.R
import com.example.wetherandwind.databinding.ActivityWindBinding

class WindScreenActivity : AppCompatActivity() {

    private val binding: ActivityWindBinding by viewBinding(ActivityWindBinding::bind)

    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)
        val speed= intent.extras?.get("speed")
        val degree = intent.extras?.get("degree")
        binding.tvSpeed.text = getString(R.string.speed, speed)
        binding.tvDegree.text = getString(R.string.degree, degree)
    }

}