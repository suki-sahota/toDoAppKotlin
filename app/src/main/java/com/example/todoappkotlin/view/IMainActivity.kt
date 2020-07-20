package com.example.todoappkotlin.view

import android.view.View
import com.example.todoappkotlin.model.TaskModel

// Abstract class is blueprint
// Interface is a contract
// Dependency Inversion is when Interface communicates between the View and Presenter
// Interface prevents hard-coding between View and Presenter

interface IMainActivity { // Abstract class/interface so it does not have a constructor
    fun initView()
    fun onBind()
    fun createNewTask(view: View)
    fun invokeCreateNewTask()
    fun displayData(dataSet: TaskModel)
}