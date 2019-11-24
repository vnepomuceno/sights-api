package io.sights

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SightsApiApplication

fun main(args: Array<String>) {
    runApplication<SightsApiApplication>(*args)
}
