package com.example.activityiteapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.activityiteapp.api.model.Activities
import com.example.activityiteapp.databinding.ViewHolderActivitiesGridBinding
import com.example.activityiteapp.databinding.ViewHolderActivitiesListBinding

class ActivitiesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_LIST = 1
    private val VIEW_TYPE_GRID = 2

    var isGrid = false
    var dataSet = emptyList<Activities>()

    private lateinit var onItemClickListener: (activities: Activities, id: Int) -> Unit

    fun setOnItemClickListener(onItemClickListener: (activities: Activities, id: Int) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }
    override fun getItemViewType(position: Int): Int {
        return if (isGrid) VIEW_TYPE_GRID else VIEW_TYPE_LIST
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == VIEW_TYPE_LIST) {
            val binding = ViewHolderActivitiesListBinding.inflate(inflater, parent, false)
            ActivitiesListViewHolder(binding)
        } else {
            val binding = ViewHolderActivitiesGridBinding.inflate(inflater, parent, false)
            ActivitiesGridViewHolder(binding)
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int)
    {
        val activity = dataSet[position]
        holder.itemView.setOnClickListener {
            onItemClickListener.invoke(activity, position)
        }
        if (holder is ActivitiesListViewHolder) {
            holder.bindList(activity)
        } else if (holder is ActivitiesGridViewHolder) {
            holder.bindGrid(activity)
        }
    }

    override fun getItemCount(): Int = dataSet.size
}
