package com.mkdev.domain.model.property

import java.util.Locale

data class OverallRatingModel(
    val numberOfRatings: String,
    val overall: Int,
) {
    fun convertOverallRating(): String {
        val convertedRating = overall.toDouble() / 10
        return String.format(locale = Locale.US, "%.1f", convertedRating)
    }
}