package com.example.islamiapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import com.example.islamiapp.databinding.FragmentSebhaBinding

final class SebhaFragment : Fragment() {

    private lateinit var viewBining: FragmentSebhaBinding
    lateinit var tasbeehFactory: TasbeehFactory
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
            animateSebha()
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

    private fun animateSebha() {
        // Create rotation animation
        val rotateAnimation = RotateAnimation(
            0f,                // Start angle
            12f,              // End angle (adjust for desired rotation amount)
            Animation.RELATIVE_TO_SELF, 0.5f,  // Pivot X
            Animation.RELATIVE_TO_SELF, 0.5f   // Pivot Y
        ).apply {
            duration = 100    // Animation duration in milliseconds
            fillAfter = true  // Maintain end position
            interpolator = LinearInterpolator()
        }

        // Start animation
        viewBining.sebhaCircle.startAnimation(rotateAnimation)
    }
}

