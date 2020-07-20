package com.example.todoappkotlin.presenter

import com.example.todoappkotlin.model.Repository
import com.example.todoappkotlin.view.ICreateNewTask

class PresenterCreateNewTask {

    var view: ICreateNewTask? = null

    fun onBind(view: ICreateNewTask) {
        this.view = view
    }

    fun isEmptyInput(textInput: String,
        spinnerInput: String): Boolean {
        if (textInput.isEmpty() || spinnerInput.isEmpty()) {
            return true
        } else {
            createModel(textInput, spinnerInput)
            return false
        }
    }

    private fun createModel(textInput: String, spinnerInput: String) {
        view!!.passDataBack(Repository.createObject(textInput, spinnerInput))
    }
}
