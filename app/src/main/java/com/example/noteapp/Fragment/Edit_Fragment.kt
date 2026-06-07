package com.example.noteapp.Fragment

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.noteapp.Model.Notes
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentEditBinding
import com.example.noteapp.viewModel.NotesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.Date
import kotlin.getValue


class Edit_Fragment : Fragment() {
val oldnotes by navArgs<Edit_FragmentArgs>()
    val viewModel: NotesViewModel by viewModels()

    var priority : String = "1"

    lateinit var binding: FragmentEditBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment


        setHasOptionsMenu(true)

        binding.edTitle.setText(oldnotes.data.title)
        binding.edSubtitle.setText(oldnotes.data.subttitle)
        binding.edNotes.setText(oldnotes.data.note)

        when (oldnotes.data.priority) {

            "1" -> {
                priority = "1"
                binding.pRed.setImageResource(R.drawable.check)
                binding.pGreen.setImageResource(0)
                binding.pYallow.setImageResource(0)

            }

            "2" -> {
                priority = "2"
                binding.pGreen.setImageResource(R.drawable.check)
                binding.pRed.setImageResource(0)
                binding.pYallow.setImageResource(0)
            }

            "3" -> {
                priority = "3"
                binding.pYallow.setImageResource(R.drawable.check)
                binding.pRed.setImageResource(0)
                binding.pGreen.setImageResource(0)
            }

        }
binding.btnsave.setOnClickListener {
    updatednotes(it)

    }


        binding.btnDeleted.setOnClickListener {
            deletednotes(it)
        }

        return binding.root

    }





    private fun updatednotes(it: View){
        val title = binding.edTitle.text.toString()
        val subtitle = binding.edSubtitle.text.toString()
        val notes = binding.edNotes.text.toString()

        val d = Date()
        val notesdate : CharSequence = DateFormat.format(
            "MMM d, yyyy",
            d.time
        )

        val Date = Notes(
           oldnotes.data.id ,
            title = title,
            subttitle = subtitle,
            note = notes,
            Date = notesdate.toString(),
            priority
        )


        viewModel.addNotes(Date)
        Toast.makeText(requireContext()," Note successfuly updated ", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_edit_Fragment_to_home_Fragment)

    }

    private fun  deletednotes(it: View){


        val bottomSheet = BottomSheetDialog(requireContext())
        bottomSheet.setContentView(R.layout.dialog_notes)

        val textviewyas = bottomSheet.findViewById<TextView>(R.id.tv_dialogYas)
        val textviewNO = bottomSheet.findViewById<TextView>(R.id.tv_dialoghNO)

        textviewyas?.setOnClickListener {
            viewModel.delectedNotes(oldnotes.data.id!!)
            Navigation.findNavController(it)
                .navigate(R.id.action_edit_Fragment_to_home_Fragment)
            bottomSheet.dismiss()
        }

        textviewNO?.setOnClickListener {
            bottomSheet.dismiss()
        }
        bottomSheet.show()
    }


}
