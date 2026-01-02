package com.example.activityiteapp.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.activityiteapp.api.model.Activities
import com.example.activityiteapp.databinding.ViewHolderActivitiesBinding

class ActivitiesAdapter: RecyclerView.Adapter<ActivitiesViewHolder>(){
    var dataSet = emptyList<Activities>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActivitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderActivitiesBinding.inflate(layoutInflater, parent, false)
        return ActivitiesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ActivitiesViewHolder,
        position: Int
    ) {
        val activities = dataSet[position]
        holder.bind(activities)
    }

    override fun getItemCount(): Int {
        return dataSet.size;
    }

}