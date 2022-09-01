package com.example.githup.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoDao {

    @Query("SELECT * FROM Repo_table")
     fun getAll(): RepoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: RepoEntity)

    @Query("DELETE FROM Repo_table")
    fun deleteAll()


}