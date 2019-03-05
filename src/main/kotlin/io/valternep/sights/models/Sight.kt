package io.valternep.sights.models

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "Sight")
data class Sight(
    val id: ObjectId,
    val citySdkId: String,
    val base: String,
    val labels: List<Label>,
    val descriptions: List<Description>?,
    val locations: List<Location>?,
    val websites: List<Website>?,
    val contact: Contact?,
    val schedules: List<Schedule>?,
    val images: List<Image>?,
    val author: Author
)

data class Label(
    val id: String = newUIID(),
    val term: String,
    val value: String,
    val language: String?
)

data class Description(
    val id: String = newUIID(),
    val value: String,
    val lang: String
)

data class Location(
    val id: String = newUIID(),
    val address: String,
    val city: String,
    val country: String,
    val coordinates: String
)

data class Website(
    val id: String = newUIID(),
    val href: String,
    val type: String
)

data class Contact(
    val phoneNumber: String?,
    val emailAddress: String?
)

data class Schedule(
    val id: String = newUIID(),
    val open: String
)

data class Image(
    val id: String = newUIID(),
    val href: String,
    val type: String
)

data class Author(
    val id: String = newUIID(),
    val source: String
)

private fun newUIID() = UUID.randomUUID().toString().replace("-", "")