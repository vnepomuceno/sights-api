package io.valternep.sights.controller

import io.valternep.sights.models.Sight
import io.valternep.sights.repository.SightsRepository
import org.bson.types.ObjectId
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
class SightsApiController(
    private val sightsRepository: SightsRepository
) {
    private val logger = LoggerFactory.getLogger(SightsApiController::class.java)

    @GetMapping("/sights")
    fun getAllSights(): List<Sight> {
        logger.info("Received request GET /sights")
        return sightsRepository.findAll()
    }

    @GetMapping("/sights/{sightId}")
    fun getSightById(
        @PathVariable sightId: String,
        @RequestParam(value = "userCoordinates", required = false) userCoordinates: String?
    ): Optional<Sight> {
        logger.info("Received request GET /sights/$sightId?userCoordinates=$userCoordinates")
        return sightsRepository.findById(ObjectId(sightId))
    }
}
