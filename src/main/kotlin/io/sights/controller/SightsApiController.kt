package io.sights.controller

import io.sights.models.Sight
import io.sights.repository.SightsRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SightsApiController(
    private val sightsRepository: SightsRepository
) {

    @GetMapping("/sights")
    fun getAllSights(): List<Sight> {
        return sightsRepository.findAll()
    }
}
