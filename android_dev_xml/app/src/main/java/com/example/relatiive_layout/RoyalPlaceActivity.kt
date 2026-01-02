package com.example.relatiive_layout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.relatiive_layout.databinding.ActivityRoyalLayoutBinding

class RoyalPlaceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoyalLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoyalLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backFromRoyal.setOnClickListener { finish() }
    }
}