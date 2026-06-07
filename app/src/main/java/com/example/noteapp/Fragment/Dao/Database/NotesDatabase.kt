package com.example.noteapp.Fragment.Dao.Database

import android.content.Context
import android.provider.CalendarContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.Fragment.Dao.Dao
import com.example.noteapp.Model.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)

abstract class NotesDatabase:RoomDatabase() {

    abstract fun myNotesDao(): Dao

    companion object{

        @Volatile
        var INSTANCE: NotesDatabase? = null

        fun getDatabaseInstance(context: Context): NotesDatabase{
            val temIstance =INSTANCE
            if (temIstance != null){
                return  temIstance
            }
                   synchronized(this)
                   {
                       val roomDatabaseInstance =
                           Room.databaseBuilder(context, NotesDatabase::class.java, "Notes").allowMainThreadQueries().build()
                       INSTANCE = roomDatabaseInstance
                       return return roomDatabaseInstance
                   }    }
        }
  }
