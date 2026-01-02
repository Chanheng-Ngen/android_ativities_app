package com.example.activityiteapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.activityiteapp.databinding.ViewHolderActivitiesBinding
import com.example.activityiteapp.api.model.Activities
import com.example.activityiteapp.databinding.ActivityMyActivitiesBinding
import com.squareup.picasso.Picasso

class ActivitiesViewHolder(val binding: ViewHolderActivitiesBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(activities: Activities){
        binding.title.text = activities.title
        binding.date.text = activities.date
        Picasso.get().load(activities.imageUrl).into(binding.imageUrl)
    }

}