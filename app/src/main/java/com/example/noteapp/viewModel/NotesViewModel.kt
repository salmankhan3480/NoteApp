package com.example.noteapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.noteapp.Fragment.Dao.Database.NotesDatabase
import com.example.noteapp.Model.Notes
import com.example.noteapp.Repository.NotesRepository



class NotesViewModel(application: Application) : AndroidViewModel(application) {
    var repository : NotesRepository

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes){
        repository.insterNotes(notes)
    }
    fun  getNotes(): LiveData<List<Notes>> = repository.fetallNotes()
    fun getlowNotes(): LiveData<List<Notes>> = repository.getlowNotes()
    fun getmediumNotes(): LiveData<List<Notes>> = repository.getmediumNotes()
    fun gethighNotes(): LiveData<List<Notes>> = repository.gethighNotes()

    fun delectedNotes (id:Int){
        repository.delectedNotes(id)

        fun updatedNotes(notes: Notes){
            repository.updatedNotes(notes)
        }
    }



}