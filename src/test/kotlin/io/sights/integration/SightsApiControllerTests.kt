package io.sights.integration

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.sights.controller.SightsApiController
import io.sights.models.Sight
import io.sights.repository.SightsRepository
import java.io.FileReader
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
import org.springframework.util.ResourceUtils
import java.io.File

@RunWith(SpringRunner::class)
@SpringBootTest
class SightsApiControllerTests {

    @Autowired
    private lateinit var sightsApiController: SightsApiController

    @Autowired
    private lateinit var sightsRepository: SightsRepository

    private val gson = Gson()
    private val listOfSights = gson.fromJson<List<Sight>>(
        FileReader(ResourceUtils.getFile("classpath:Sight.json")),
        object : TypeToken<List<Sight>>() {}.type
    )

    @Before
    fun setUp() {
        sightsRepository.deleteAll()
        sightsRepository.saveAll(listOfSights)
    }

    @Test
    fun `GET to sights endpoint`() {
        val mockMvc = MockMvcBuilders.standaloneSetup(sightsApiController)
            .apply<StandaloneMockMvcBuilder>(SharedHttpSessionConfigurer.sharedHttpSession())
            .build()

        mockMvc.perform(get("/sights"))
            .andExpect(status().isOk)
            .andExpect(content().json(gson.toJson(listOfSights)))
    }
}
