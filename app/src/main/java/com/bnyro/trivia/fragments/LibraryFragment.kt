package com.bnyro.trivia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bnyro.trivia.adapters.LibraryAdapter
import com.bnyro.trivia.databinding.FragmentLibraryBinding
import com.bnyro.trivia.dialogs.CreateQuizDialog
import com.bnyro.trivia.dialogs.DownloadDialog
import com.bnyro.trivia.util.PreferenceHelper

class LibraryFragment : Fragment() {
    private lateinit var binding: FragmentLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLibraryBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (PreferenceHelper.getQuizzes().isNotEmpty()) binding.libraryEmpty.visibility = View.GONE

        binding.libraryRV.layoutManager = LinearLayoutManager(context)
        binding.libraryRV.adapter = LibraryAdapter(this)

        binding.downloadFAB.setOnClickListener {
            DownloadDialog().show(childFragmentManager, null)
        }

        binding.createFAB.setOnClickListener {
            CreateQuizDialog().show(childFragmentManager, null)
        }
    }
}
