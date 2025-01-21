package com.example.islamiapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islamiapp.databinding.QuranChaptersItemBinding
import com.example.islamiapp.model.QuranChapter
import com.example.islamiapp.model.QuranChapterSura

class QuranChaptersAdapter(val  suras: List<QuranChapterSura>) :
    Adapter<QuranChaptersAdapter.QuranChapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranChapterViewHolder {
        val inflatter = LayoutInflater.from(parent.context)
        val viewBining = QuranChaptersItemBinding.inflate(inflatter)
        return QuranChapterViewHolder(viewBining)
    }

    override fun getItemCount(): Int {
        return suras.size
    }

    override fun onBindViewHolder(holder: QuranChapterViewHolder, position: Int) {
        val item = suras[position]
        holder.binding(item)
    }

    class QuranChapterViewHolder(val viewBinding: QuranChaptersItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun binding(model: QuranChapterSura) {
            viewBinding.surahArText.text = model.arabicName
            viewBinding.surahEnText.text = model.name
            viewBinding.surasOrderText.text = model.id.toString()
            viewBinding.surahVersusText.text = model.verses.toString()
        }
    }


}