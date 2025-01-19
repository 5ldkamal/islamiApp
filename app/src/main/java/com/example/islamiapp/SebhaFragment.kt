package com.example.islamiapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.example.islamiapp.databinding.FragmentSebhaBinding

final class SebhaFragment : Fragment() {

    private lateinit var viewBining: FragmentSebhaBinding
    lateinit var tasbeehFactory: TasbeehFactory
//    private var counter: Int = 0
//    private var currentIndex = 0
//
//    private val tasbeehTexts = listOf(
//        "سبحان الله", // Subhan Allah
//        "الحمد لله", // Alhamdulillah
//        "الله أكبر", // Allahu Akbar
//        "لا إله إلا الله" // La ilaha illallah
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBining = FragmentSebhaBinding.inflate(inflater, container, false)
        tasbeehFactory = TasbeehFactory()
        updateTexts()
        didSebhaClick()
        return viewBining.root
    }

    private fun didSebhaClick() {
        viewBining.sebhaContainerId.setOnClickListener({
            updateCounter()
        })
    }

    private fun updateCounter() {
        tasbeehFactory.updateCounter()
        updateTexts()
    }

    private fun updateTexts() {
        viewBining.counterText.text = tasbeehFactory.counter.toString()
        viewBining.tasbeehText.text = tasbeehFactory.getCurrentTasbeehText()
    }
}

