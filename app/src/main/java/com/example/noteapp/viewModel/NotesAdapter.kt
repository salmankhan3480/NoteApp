package com.example.noteapp.viewModel

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.Fragment.Home_FragmentDirections
import com.example.noteapp.Model.Notes
import com.example.noteapp.R
import com.example.noteapp.databinding.ItemNotesBinding


class NotesAdapter(val requiredContext: Context,private var notexlist : List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesviewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): notesviewHolder {
        return notesviewHolder(ItemNotesBinding.inflate(LayoutInflater.from(requiredContext),parent,false))
    }

    override fun onBindViewHolder(
        holder: notesviewHolder,
        position: Int
    ) {
         val data = notexlist[position]
        holder.binding.noteTitle.text = data.title
        holder.binding.notesubTitle.text = data.subttitle
        holder.binding.notedate.text = data.Date

        when(data.priority){

            "1"->{
                holder.binding.proritey.setBackgroundResource(R.drawable.redcolorshape)
            }
            "2"-> {
               holder.binding.proritey.setBackgroundResource(R.drawable.greendots)
            }
            "3"->{
                 holder.binding.proritey.setBackgroundResource(R.drawable.yallowdot)
            }
        }
        holder.binding.root.setOnClickListener {
            val actin = Home_FragmentDirections.actionHomeFragmentToEditFragment(data)
            Navigation.findNavController(it).navigate(actin)

        }


    }


    override fun getItemCount(): Int {
       return notexlist.size
    }


    class notesviewHolder(val binding: ItemNotesBinding ): RecyclerView.ViewHolder(binding.root)


}