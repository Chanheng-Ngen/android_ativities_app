package com.example.relatiive_layout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.relatiive_layout.databinding.ActivityDitionaryBinding

class DitionaryActivity : AppCompatActivity(){
    private lateinit var binding: ActivityDitionaryBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDitionaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backFromDition.setOnClickListener { finish() }
    }

}