package com.abdallahyasser.areacalculator.triangleScreen

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.abdallahyasser.areacalculator.quadrilateralScreen.Quadrilater

@Dao
interface TraingleDAO {

    @Query("SELECT * FROM Traingle")
    suspend fun getAll() :List<Traingle>

    @Update
    suspend fun update(t: Traingle)

    @Delete
    suspend fun delete(t: Traingle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: Traingle)
}