package com.example.activityiteapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
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
        binding.year1.setOnClickListener {
            resetYearButtons()
            binding.year1.setTextColor(getColor(R.color.blue_active))
            adapter.filterByYear(1.toInt())
            updateEmptyState()
        }
        binding.year2.setOnClickListener {
            resetYearButtons()
            binding.year2.setTextColor(getColor(R.color.blue_active))
            adapter.filterByYear(2.toInt())
            updateEmptyState()
        }
        binding.year3.setOnClickListener {
            resetYearButtons()
            binding.year3.setTextColor(getColor(R.color.blue_active))
            adapter.filterByYear(3.toInt())
            updateEmptyState()
        }
        binding.year4.setOnClickListener {
            resetYearButtons()
            binding.year4.setTextColor(getColor(R.color.blue_active))
            adapter.filterByYear(4.toInt())
            updateEmptyState()
        }
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
                binding.major.text = profile.major
                binding.generation.text = profile.generation
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
        adapter.setData(activities)
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

            adapter.isGrid = isGrid

            if (isGrid) {
                binding.rclAct.layoutManager = GridLayoutManager(this, 2)
                binding.grid.setImageResource(R.drawable.list_solid_full)
            } else {
                binding.rclAct.layoutManager = LinearLayoutManager(this)
                binding.grid.setImageResource(R.drawable.grid_2)
            }
        }
    }

    private fun resetYearButtons() {
        binding.year1.setTextColor(getColor(R.color.gray))
        binding.year2.setTextColor(getColor(R.color.gray))
        binding.year3.setTextColor(getColor(R.color.gray))
        binding.year4.setTextColor(getColor(R.color.gray))
    }

    private fun updateEmptyState() {
        if (adapter.itemCount == 0) {
            binding.rclAct.visibility = View.GONE
            binding.txtNotFound.visibility = View.VISIBLE
            Log.d("[item]", "empty (${adapter.itemCount}, ${adapter.itemCount == 0})")
        } else {
            binding.rclAct.visibility = View.VISIBLE
            binding.txtNotFound.visibility = View.GONE
            Log.d("[item]", "empty (${adapter.itemCount}), ${adapter.itemCount == 0}")
        }
    }
}
