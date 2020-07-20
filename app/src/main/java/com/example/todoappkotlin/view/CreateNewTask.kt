package com.example.todoappkotlin.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todoappkotlin.R
import com.example.todoappkotlin.model.TaskModel
import com.example.todoappkotlin.presenter.Presenter
import com.example.todoappkotlin.presenter.PresenterCreateNewTask
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_create_new_task.*

class CreateNewTask : AppCompatActivity(), ICreateNewTask {

    companion object { // Companion objects are created at compile time (vs static runtime)
        const val PARCELABLE_KEY: String = "CREATENEWTASK" // Use const for compile time values
    }
//        private val TAG = CreateNewTask::class.java.simpleName // "CreateNewTask"
    val presenter: PresenterCreateNewTask by lazy { PresenterCreateNewTask() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_task)

        initViews()
        onBindPresenter()
        btn_save_task.setOnClickListener {
            inputData()
        }
    }

    override fun initViews() {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        adapter.add("Coding")
        adapter.add("Cooking")
        adapter.add("Laundry")
        adapter.add("Soft Skills")
        spinner.adapter = adapter
    }

    override fun onBindPresenter() {
        presenter.onBind(this)
    }

    override fun inputData() {
        if (presenter.isEmptyInput(
                til_create_task.editText!!.text.toString(),
                spinner.selectedItem.toString())) {
            Toast.makeText(this, "No empty values!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun passDataBack(dataItem: TaskModel) {
        val intentResult = Intent()
        intentResult.putExtra(PARCELABLE_KEY, dataItem)
        setResult(Activity.RESULT_OK, intentResult)
        finish()
    }
}