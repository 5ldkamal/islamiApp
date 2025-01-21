package com.example.islamiapp.model

import android.content.Context
import kotlinx.serialization.json.Json

class QuranChaptersJsonReader {

    fun getChapters(context: Context, rawResId: Int): QuranChapter? {

        try {
            val file = readRawResourceFile(context, rawResId)
            val model = parseJsonFile(file)
            return model
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    private fun parseJsonFile(file: String): QuranChapter {
        return Json.decodeFromString(file)
    }

    private fun readRawResourceFile(context: Context, rawResId: Int): String {
        val inputStream = context.resources.openRawResource(rawResId)
        return inputStream.bufferedReader().use { it.readText() }
    }

}