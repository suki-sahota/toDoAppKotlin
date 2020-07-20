package com.example.todoappkotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(
    val name: String = "N/A",
    val type: String = "N/A"
): Parcelable