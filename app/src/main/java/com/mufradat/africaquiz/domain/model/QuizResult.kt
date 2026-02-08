package com.mufradat.africaquiz.domain.model

data class QuizResult(
    val totalQuestions: Int,
    val correctCount: Int,
    val scorePercentage: Int,
    val questionDetails: List<QuestionDetail>
)

data class QuestionDetail(
    val countryName: String,
    val correctAnswer: String,
    val userAnswer: String?,
    val isCorrect: Boolean
)
