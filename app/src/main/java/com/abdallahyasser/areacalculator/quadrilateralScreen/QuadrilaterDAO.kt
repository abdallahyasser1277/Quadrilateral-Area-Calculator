package com.abdallahyasser.areacalculator.quadrilateralScreen

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuadrilaterDAO {

    @Query("SELECT * FROM quadrilater")
    suspend fun getAll() :List<Quadrilater>

    @Update
    suspend fun update(q:Quadrilater)

    @Delete
    suspend fun delete(q: Quadrilater)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(q: Quadrilater)

}