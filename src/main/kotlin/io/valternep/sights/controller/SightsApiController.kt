package io.valternep.sights.controller

import io.valternep.sights.models.Sight
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SightsApiController {

    @GetMapping("/sights")
    fun getAllSights(): List<Sight> {
        return listOf()
    }
}
