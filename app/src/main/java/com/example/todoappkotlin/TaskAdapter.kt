package com.example.todoappkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoappkotlin.model.TaskModel
import kotlinx.android.synthetic.main.task_item_layout.view.*

class TaskAdapter(): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    var dataSet: MutableList<TaskModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TaskViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.task_item_layout,
                    parent,
                    false
                )
        )

    override fun getItemCount(): Int {
        return dataSet?.size ?: 0
    }

    override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {
        dataSet?.let {
            holder.onBind(it[position])
        }
    }

    class TaskViewHolder(itemTask: View) : RecyclerView.ViewHolder(itemTask) {

        fun onBind(item: TaskModel) {
            itemView.tv_category_item.text = item.categoryType.name
            itemView.tv_task_item.text = item.taskName
        }
    }
}