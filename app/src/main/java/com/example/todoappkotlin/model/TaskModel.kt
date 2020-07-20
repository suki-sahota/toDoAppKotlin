package com.example.todoappkotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class TaskModel(
    val taskName: String,
    val categoryType: CategoryModel
): Parcelable