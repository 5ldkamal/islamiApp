package com.example.islamiapp.model

import kotlinx.serialization.Serializable

// Step 3: Define data classes for the JSON structure

@Serializable
data class QuranChapter(
    val suras: List<QuranChapterSura>
)

@Serializable
data class QuranChapterSura(
    val id: Int,
    val name: String,
    val verses: Int,
    val arabicName: String
)

