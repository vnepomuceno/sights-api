package io.valternep.sights.controller

import io.valternep.sights.models.Sight
import io.valternep.sights.repository.SightsRepository
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
