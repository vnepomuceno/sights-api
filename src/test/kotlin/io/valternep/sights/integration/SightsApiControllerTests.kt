package io.valternep.sights.integration

import com.google.gson.Gson
import io.valternep.sights.controller.SightsApiController
import io.valternep.sights.models.Author
import io.valternep.sights.models.Contact
import io.valternep.sights.models.Description
import io.valternep.sights.models.Sight
import io.valternep.sights.repository.SightsRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder
import java.util.UUID

@RunWith(SpringRunner::class)
@SpringBootTest
class SightsApiControllerTests {

    @Autowired
    private lateinit var sightsApiController: SightsApiController

    @Autowired
    private lateinit var sightsRepository: SightsRepository

    private val gson = Gson()

    @Before
    fun setUp() {
        sightsRepository.deleteAll()
    }

    @Test
    fun `GET to sights endpoint`() {
        val sights = listOf(
            Sight(
                id = UUID.randomUUID().toString().replace("-", ""),
                citySdkId = "citySdkId",
                base = "base",
                labels = listOf(),
                descriptions = listOf(
                    Description("descriptionId", "description", "en")
                ),
                locations = listOf(),
                websites = listOf(),
                contact = Contact("phoneNumber", "emailAddress"),
                schedules = listOf(),
                images = listOf(),
                author = Author("authorId", "source")
            )
        )
        sightsRepository.save(sights.first())

        val mockMvc = MockMvcBuilders.standaloneSetup(sightsApiController)
            .apply<StandaloneMockMvcBuilder>(SharedHttpSessionConfigurer.sharedHttpSession())
            .build()

        mockMvc.perform(get("/sights"))
            .andExpect(status().isOk)
            .andExpect(content().json(gson.toJson(sights)))
    }
}