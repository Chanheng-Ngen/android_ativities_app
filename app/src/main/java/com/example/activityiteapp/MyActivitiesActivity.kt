package com.example.activityiteapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.activityiteapp.adapter.ActivitiesAdapter
import com.example.activityiteapp.api.model.Activities
import com.example.activityiteapp.api.service.ApiService
import com.example.activityiteapp.databinding.ActivityMyActivitiesBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyActivitiesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyActivitiesBinding
    private lateinit var adapter: ActivitiesAdapter
    private var isGrid = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadProfile()
        loadActivities()
        changeDisplay();
    }
    private fun loadProfile(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://smlp-pub.s3.ap-southeast-1.amazonaws.com/final-2025/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        val apiService = retrofit.create(ApiService::class.java)
        lifecycleScope.launch {
            try {
                val profile = apiService.getProfile()
                binding.firstName.text = profile.firstName
                binding.lastName.text = profile.lastName
                Picasso.get().load(profile.profileImage).into(binding.profileImg)
                Picasso.get().load(profile.coverImage).into(binding.coverImage)
            }catch (error: Exception){
                Log.d("[get-profile]", "loading profile ${error.message}")
            }
        }
    }
    private fun loadActivities(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://smlp-pub.s3.ap-southeast-1.amazonaws.com/final-2025/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        val apiService = retrofit.create(ApiService::class.java)
        lifecycleScope.launch {
            try {
                val activities = apiService.getActivities()
                displayActivities(activities)
            }catch (error: Exception){
                Log.d("[get-activities]", "loading activities ${error.message}")
            }
        }
    }

    private fun displayActivities(activities: List<Activities>) {
        adapter = ActivitiesAdapter()
        adapter.dataSet = activities
        adapter.setOnItemClickListener { activitie, position ->
//            Toast.makeText(this@MyActivitiesActivity, activities.id.toString(), Toast.LENGTH_SHORT).show()4
            val intent = Intent(this@MyActivitiesActivity, MyActivitiesDetailActivity::class.java)
            intent.putExtra("Activities", activitie)
            startActivity(intent)
        }
        binding.rclAct.adapter = adapter
        binding.rclAct.layoutManager = LinearLayoutManager(this)
    }


    private fun changeDisplay() {
        binding.grid.setOnClickListener {
            isGrid = !isGrid

            adapter.isGrid = isGrid   // 🔥 IMPORTANT

            if (isGrid) {
                binding.rclAct.layoutManager = GridLayoutManager(this, 2)
                binding.grid.setImageResource(R.drawable.list_solid_full)
            } else {
                binding.rclAct.layoutManager = LinearLayoutManager(this)
                binding.grid.setImageResource(R.drawable.grid_2)
            }
        }
    }


}
