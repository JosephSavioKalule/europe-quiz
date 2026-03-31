package com.mufradat.europequiz.data.repository

import android.content.Context
import com.mufradat.europequiz.data.local.AssetJsonParser
import com.mufradat.europequiz.data.model.Country
import com.mufradat.europequiz.data.model.QuizData

class QuizRepository(context: Context) {

    private val data: QuizData by lazy {
        AssetJsonParser(context.applicationContext).parse()
    }

    val countries: List<Country>
        get() = data.countries

    val distractors: List<String>
        get() = data.distractors
}
