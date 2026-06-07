package com.example.noteapp.Fragment.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.Model.Notes

@Dao
interface Dao {

    @Query("SELECT * FROM NOTES")
    fun getNotes(): LiveData<List<Notes>>

    @Query("SELECT * FROM NOTES WHERE priority =1")
    fun getHifhNotes(): LiveData<List<Notes>>

    @Query("SELECT * FROM NOTES WHERE priority =3")
    fun getmediumNotes(): LiveData<List<Notes>>

    @Query("SELECT * FROM NOTES WHERE priority=2")
    fun getlowNotes(): LiveData<List<Notes>>
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun inserNotes(notes: Notes)

    @Query ("DELETE FROM NOTES WHERE Id=:id")
    fun deleteNotes(id: Int)

    @Update
    fun updatedNotes(notes: Notes)
}
