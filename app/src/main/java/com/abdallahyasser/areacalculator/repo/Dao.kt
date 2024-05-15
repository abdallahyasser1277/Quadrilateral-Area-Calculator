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

    @Query("SELECT * FROM Traingle ORDER BY ID DESC LIMIT 1")
    suspend fun getLastTraingle():Traingle

    @Query("SELECT * FROM Quadrilater ORDER BY ID DESC LIMIT 1")
    suspend fun getLastQuadrilater():Quadrilater

    @Update(entity = Traingle::class)
    suspend fun update(t: Traingle)

    @Delete(entity = Traingle::class)
    suspend fun delete(t: Traingle)

    @Insert(entity = Traingle::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: Traingle)
    @Query("SELECT * FROM quadrilater")
    suspend fun getAllQuadrilaters() :List<Quadrilater>

    @Update(entity = Quadrilater::class)
    suspend fun update(q: Quadrilater)

    @Delete(entity = Quadrilater::class)
    suspend fun delete(q: Quadrilater)

    @Insert(entity = Quadrilater::class,onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(q: Quadrilater)

}