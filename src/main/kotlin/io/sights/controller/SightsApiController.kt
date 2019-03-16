package io.sights.controller

import io.sights.models.SightOverview
import io.sights.repository.SightsRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SightsApiController(
    private val sightsRepository: SightsRepository
) {

    @GetMapping("/sights")
    fun getAllSights(): List<SightOverview> {
        return sightsRepository.findAll().map { sight ->
            SightOverview(
                id = sight.id,
                name = sight.labels.first().value,
                coverPhoto = sight.images?.first()?.href,
                distanceFromUserMeters = null,
                userArrivesInMinutes = null
            )
        }
    }
}
