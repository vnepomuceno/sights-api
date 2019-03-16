package io.sights.models

data class SightOverview(
    val id: String,
    val name: String,
    val coverPhoto: String?,
    val distanceFromUserMeters: Int?,
    val userArrivesInMinutes: Int?,
    val rating: Float = 0.0f,
    val favorites: Int = 0
)
