package com.example.todoappkotlin.view

import com.example.todoappkotlin.model.TaskModel

interface ICreateNewTask {
    fun onBindPresenter()
    fun initViews()
    fun inputData()
    fun passDataBack(dataItem: TaskModel)
}