package com.example.todoappkotlin.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoappkotlin.R
import com.example.todoappkotlin.TaskAdapter
import com.example.todoappkotlin.model.CategoryModel
import com.example.todoappkotlin.model.TaskModel
import com.example.todoappkotlin.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainActivity { // Only one set of () after colon (one implementation)

    // private val TAG = MainActivity::class.java.simpleName // "MainActivity"
    private val REQUEST_CODE = 3237
    private val adapter: TaskAdapter by lazy { TaskAdapter() }
    val presenter: Presenter by lazy { Presenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        onBind()
    }

    override fun initView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
    }

    override fun onBind() {
        presenter.onBind(this)
        presenter.loadData() // Does not do anything right now
    }

    override fun createNewTask(view: View) {
        invokeCreateNewTask()
    }

    override fun invokeCreateNewTask() {
        startActivityForResult(
            Intent(this,
                CreateNewTask::class.java),
            REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
//            displayData(
//                data.getParcelableExtra<TaskModel>(CreateNewTask.PARCELABLE_KEY) ?:
//            TaskModel("N/A", CategoryModel(name = "N/A")))
            data?.getParcelableExtra<TaskModel>(CreateNewTask.PARCELABLE_KEY)?.let {
                displayData(it)
            }
        }
    }

    override fun displayData(dataSet: TaskModel) {
        adapter.dataSet.add(dataSet)
        adapter.notifyItemInserted(adapter.dataSet.size - 1)
    }
}