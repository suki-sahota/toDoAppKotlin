package com.example.todoappkotlin.presenter

import com.example.todoappkotlin.view.IMainActivity

class Presenter {

    var view: IMainActivity? = null

    fun onBind(view: IMainActivity) {
        this.view = view
    }

    fun loadData() {
        //view.displayData()
    }
}