package io.valternep.sights.repository

import io.valternep.sights.models.Sight
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SightsRepository : MongoRepository<Sight, ObjectId>