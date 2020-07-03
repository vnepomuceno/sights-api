package io.sights

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableAdminServer
@SpringBootApplication
class SightsApiApplication

fun main(args: Array<String>) {
    runApplication<SightsApiApplication>(*args)
}
