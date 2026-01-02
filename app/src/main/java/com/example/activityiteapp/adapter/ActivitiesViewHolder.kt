package com.example.activityiteapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.activityiteapp.api.model.Activities
import com.example.activityiteapp.databinding.ViewHolderActivitiesGridBinding
import com.example.activityiteapp.databinding.ViewHolderActivitiesListBinding
import com.squareup.picasso.Picasso

class ActivitiesListViewHolder(val binding: ViewHolderActivitiesListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindList(activities: Activities){
        binding.title.text = activities.title
        binding.date.text = activities.date
        Picasso.get().load(activities.imageUrl).into(binding.imageUrl)
    }
}
class ActivitiesGridViewHolder( val binding: ViewHolderActivitiesGridBinding) : RecyclerView.ViewHolder( binding.root) {

    fun bindGrid(activities: Activities){
        binding.title.text = activities.title
        binding.date.text = activities.date
        Picasso.get().load(activities.imageUrl).into(binding.imageUrl)
    }
}
