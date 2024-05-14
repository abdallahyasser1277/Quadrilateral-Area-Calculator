package com.abdallahyasser.areacalculator.repo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.abdallahyasser.areacalculator.quadrilateralScreen.Quadrilater
import com.abdallahyasser.areacalculator.triangleScreen.Traingle

@Dao
interface Dao {
    @Query("SELECT * FROM Traingle")
    suspend fun getAll() :List<Traingle>

    @Update
    suspend fun update(t: Traingle)

    @Delete
    suspend fun delete(t: Traingle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: Traingle)
    @Query("SELECT * FROM quadrilater")
    suspend fun getAllQuadrilaters() :List<Quadrilater>

    @Update
    suspend fun update(q: Quadrilater)

    @Delete
    suspend fun delete(q: Quadrilater)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(q: Quadrilater)

}