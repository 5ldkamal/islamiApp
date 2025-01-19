package com.example.islamiapp

class TasbeehFactory {
    var counter: Int = 0
    private var currentIndex = 0
    val maxValue: Int = 33

    private val tasbeehTexts = listOf(
        "سبحان الله", // Subhan Allah
        "الحمد لله", // Alhamdulillah
        "الله أكبر", // Allahu Akbar
        "لا إله إلا الله" // La ilaha illallah
    )

    fun getCurrentTasbeehText(): String = tasbeehTexts[currentIndex]

    fun updateCounter() {
        var value = counter + 1
        if (value > maxValue) {
            counter = 0
            currentIndex = (currentIndex + 1) % tasbeehTexts.count()
        } else {
            counter = value
        }
    }

}