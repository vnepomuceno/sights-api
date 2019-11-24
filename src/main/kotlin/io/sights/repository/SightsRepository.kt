package io.sights.repository

import io.sights.models.Sight
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SightsRepository : MongoRepository<Sight, String>