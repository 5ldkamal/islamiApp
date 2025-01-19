package com.example.islamiapp

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val file = readRawResourceFile(this, R.raw.quran)
        var model = parseJson(file)
        println(model)

    }

    fun parseJson(file: String): Islami {
        return Json.decodeFromString(file)
    }

    fun readRawResourceFile(context: Context, rawResId: Int): String {
// Open the raw resource file and read its contents
        val inputStream = context.resources.openRawResource(rawResId)
        return inputStream.bufferedReader().use { it.read() }.toString()
    }

}


// Step 3: Define data classes for the JSON structure
@kotlinx.serialization.Serializable
data class Islami(
    val suras: List<Sura>
)

@Serializable
data class Sura(
    val id: Int,
    val name: String,
    val verses: Int,
    val arabicName: String
)

