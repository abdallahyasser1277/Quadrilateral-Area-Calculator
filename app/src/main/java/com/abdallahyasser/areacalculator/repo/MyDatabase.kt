package com.abdallahyasser.areacalculator.repo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abdallahyasser.areacalculator.quadrilateralScreen.Quadrilater
import com.abdallahyasser.areacalculator.triangleScreen.Traingle

@Database(
    entities = [Quadrilater::class,Traingle::class],
    version = 2,
    exportSchema = false
)
abstract class MyDatabase:RoomDatabase(){
    abstract val dao:Dao


    companion object{

        @Volatile
        private var daoInstance:Dao? = null
        private fun buildDatabase(context: Context):MyDatabase =  Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java,
                "my_database")
                .fallbackToDestructiveMigration().build()

        fun getDaoInstance(context: Context): Dao =
            synchronized(this){
            daoInstance ?: buildDatabase(context).dao
            }

    }
}