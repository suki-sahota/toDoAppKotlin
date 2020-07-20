package com.example.todoappkotlin.model

object Repository {
    fun createObject(textInput: String, spinnerInput: String): TaskModel {
        val categoryModel = CategoryModel(name = spinnerInput)
        val taskModel = TaskModel(textInput, categoryModel)
        return taskModel
    }

}