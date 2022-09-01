package com.example.githup.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Repo_table")
data class RepoEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val login: String,
    val description: String,
    val fork :Boolean
)



