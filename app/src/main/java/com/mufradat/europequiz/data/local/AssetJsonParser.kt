package com.mufradat.europequiz.data.local

import android.content.Context
import com.mufradat.europequiz.data.model.QuizData
import com.mufradat.europequiz.util.Constants
import com.google.gson.Gson

class AssetJsonParser(private val context: Context) {

    fun parse(): QuizData {
        val json = context.assets
            .open(Constants.DATA_ASSET_PATH)
            .bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(json, QuizData::class.java)
    }
}
