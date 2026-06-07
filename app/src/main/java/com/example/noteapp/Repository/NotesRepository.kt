package com.example.noteapp.Repository

import androidx.lifecycle.LiveData
import com.example.noteapp.Fragment.Dao.Dao
import com.example.noteapp.Model.Notes

class NotesRepository(val dao: Dao) {


    fun fetallNotes(): LiveData<List<Notes>> = dao.getNotes()

    fun getlowNotes(): LiveData<List<Notes>> = dao.getlowNotes()
    fun getmediumNotes(): LiveData<List<Notes>> = dao.getmediumNotes()
    fun gethighNotes(): LiveData<List<Notes>> = dao.getHifhNotes()
        fun insterNotes(notes: Notes) {
            dao.inserNotes(notes)
        }

        fun delectedNotes(id: Int) {
            dao.deleteNotes(id)
        }

        fun updatedNotes(notes: Notes) {
            dao.updatedNotes(notes)
        }


}