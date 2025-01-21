package com.example.islamiapp

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.ActivityMainBinding
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.File

final class MainActivity : AppCompatActivity() {


    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        didSelectItemBottomNavigationView()

    }

    private fun didSelectItemBottomNavigationView() {
        viewBinding.menuView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.quran_item_id -> {
                    showFragment(QuranFragment())
                    true
                }

                R.id.sebha_item_id -> {
                    showFragment(SebhaFragment())
                    true
                }

                else -> true
            }

        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.frameLayout.id, fragment)
            .commit()
    }
}

