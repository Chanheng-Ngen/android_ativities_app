package com.example.activityiteapp

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.activityiteapp.databinding.ActivityMyActivitiesDetailBinding
import com.example.activityiteapp.api.model.Activities
import com.squareup.picasso.Picasso

class MyActivitiesDetailActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMyActivitiesDetailBinding
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyActivitiesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val activitie = intent.getSerializableExtra("Activities", Activities::class.java)
        binding.title.text = activitie?.title
        binding.description.text = activitie?.description
        binding.date.text = activitie?.date
        Picasso.get().load(activitie?.imageUrl).into(binding.image)
        binding.back.setOnClickListener { finish() }
    }
}