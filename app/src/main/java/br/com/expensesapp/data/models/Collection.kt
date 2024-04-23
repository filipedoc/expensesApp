package br.com.expensesapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collection")
data class Collection(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String
)
