package com.mufradat.africaquiz.data.local

import android.content.Context
import com.mufradat.africaquiz.data.model.QuizData
import com.mufradat.africaquiz.util.Constants
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
