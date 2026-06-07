package com.example.noteapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.noteapp.Model.Notes
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentCreatefragmentBinding
import com.example.noteapp.viewModel.NotesViewModel
import android.text.format.DateFormat
import android.widget.Toast
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import java.util.Date


class Createfragment : Fragment() {
    val viewModel: NotesViewModel by viewModels()
    var priority : String = "1"
lateinit var binding: FragmentCreatefragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatefragmentBinding.inflate(layoutInflater,container,false)


        binding.pRed.setImageResource(R.drawable.check)

        binding.pRed.setOnClickListener {
            priority="1"
            binding.pRed.setImageResource(R.drawable.check)
            binding.pGreen.setImageResource(0)
            binding.pYallow.setImageResource(0)
        }
        binding.pGreen.setOnClickListener {
            priority = "2"
            binding.pGreen.setImageResource(R.drawable.check)
            binding.pRed.setImageResource(0)
            binding.pYallow.setImageResource(0)
        }
        binding.pYallow.setOnClickListener {
            priority = "3"
            binding.pYallow.setImageResource(R.drawable.check)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }



        binding.btnsave.setOnClickListener {
            CreateNotes()

        }


      return  binding.root
    }

    private fun CreateNotes() {

        val title = binding.edTitle.text.toString()
        val subtitle = binding.edSubtitle.text.toString()
        val notes = binding.edNotes.text.toString()



        val d = Date()
        val notesdate : CharSequence = DateFormat.format(
            "MMM d, yyyy",
            d.time
        )
        val Date = Notes(
            null,
            title = title,
            subttitle = subtitle,
            note = notes,
            Date = notesdate.toString(),
            priority
        )
        viewModel.addNotes(Date)
        Toast.makeText(requireContext()," Note create uccessfuly ", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(requireView()).navigate(R.id.action_createfragment_to_home_Fragment2)

    }

}