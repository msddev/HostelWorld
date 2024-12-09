package com.mkdev.presentation.model.property

import java.util.Locale


internal data class OverallRatingModel(
    val numberOfRatings: String,
    val overall: Int,
) {
    fun convertOverallRating(): String {
        val convertedRating = overall.toDouble() / 10
        return String.format(locale = Locale.US, "%.1f", convertedRating)
    }
}