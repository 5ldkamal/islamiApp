package com.example.islamiapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.adapter.QuranChaptersAdapter
import com.example.islamiapp.databinding.FragmentQuranBinding
import com.example.islamiapp.databinding.FragmentSebhaBinding
import com.example.islamiapp.model.QuranChapterSura
import com.example.islamiapp.model.QuranChaptersJsonReader


final class QuranFragment : Fragment() {

    lateinit var viewBinding: FragmentQuranBinding
    lateinit var quranChaptersJsonReader: QuranChaptersJsonReader
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentQuranBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranChaptersJsonReader = QuranChaptersJsonReader()
        val list = quranChaptersJsonReader.getChapters(view.context, R.raw.quran)

        viewBinding.recyclerView.adapter =
            QuranChaptersAdapter(list?.suras ?: emptyList())

    }

}