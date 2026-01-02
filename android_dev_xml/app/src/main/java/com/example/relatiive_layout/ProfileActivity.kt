package com.example.relatiive_layout
import android.util.Log
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.relatiive_layout.api.service.ApiService
import com.example.relatiive_layout.databinding.ActivityFbProfileBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFbProfileBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setup UI
        binding = ActivityFbProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Setup event listener
        binding.editCover.setOnClickListener { openRoyalPlace() }
        binding.editPublic.setOnClickListener { openDitionary() }
        loadAndDisplayProfile();
    }

    private fun openRoyalPlace(){
        val intent = Intent(this, RoyalPlaceActivity::class.java)
        Log.d("Hello", "Heloo")
        startActivity(intent)
    }
    private fun openDitionary(){
        val intent = Intent(this, DitionaryActivity::class.java)
        startActivity(intent)
    }

    private fun loadAndDisplayProfile(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        val apiService = retrofit.create(ApiService::class.java)
        GlobalScope.launch {
            try{
                val profile = apiService.getProfile()
                binding.nameAcc.text = profile[0].title.trim().split(" ")[0];
                binding.nameProfile.text = profile[0].title;
                Log.d("[product]",  "$profile")
            }catch (ex: Exception){
                Log.d("[profile-activity]", "loading profile error ${ex.message}")
            }
        }
    }
}