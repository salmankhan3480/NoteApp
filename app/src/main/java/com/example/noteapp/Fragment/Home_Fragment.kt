package com.example.noteapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentHomeBinding
import com.example.noteapp.viewModel.NotesAdapter
import com.example.noteapp.viewModel.NotesViewModel


class Home_Fragment : Fragment() {
    val viewModel: NotesViewModel by viewModels()
        lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)


        viewModel.getNotes().observe(viewLifecycleOwner,{ noteslast ->
            binding.reyclerview.layoutManager= GridLayoutManager(requireContext(),  2)
            binding.reyclerview.adapter = NotesAdapter(requireContext(),noteslast)
        })

        binding.filterAll.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner,{ noteslast ->
                binding.reyclerview.layoutManager= GridLayoutManager(requireContext(),  2)
                binding.reyclerview.adapter = NotesAdapter(requireContext(),noteslast)
            })
        }
        binding.filterHigh.setOnClickListener {
            viewModel.gethighNotes().observe(viewLifecycleOwner,{ noteslast ->
                binding.reyclerview.layoutManager= GridLayoutManager(requireContext(),  2)
                binding.reyclerview.adapter = NotesAdapter(requireContext(),noteslast)
            })
        }
       binding.filtermedium.setOnClickListener {
           viewModel.getmediumNotes().observe(viewLifecycleOwner,{ noteslast ->
               binding.reyclerview.layoutManager= GridLayoutManager(requireContext(),  2)
               binding.reyclerview.adapter = NotesAdapter(requireContext(),noteslast)



           })
       }

        binding.filterlow.setOnClickListener {

            viewModel.getlowNotes().observe(viewLifecycleOwner,{ noteslast ->
                binding.reyclerview.layoutManager= GridLayoutManager(requireContext(),  2)
                binding.reyclerview.adapter = NotesAdapter(requireContext(),noteslast)



            })


        }

        binding.btnsave.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_home_Fragment_to_createfragment)
        }




        return binding.root
    }


}