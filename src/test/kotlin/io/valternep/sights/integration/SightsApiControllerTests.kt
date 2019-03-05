package io.valternep.sights.integration

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.valternep.sights.controller.SightsApiController
import io.valternep.sights.models.Sight
import io.valternep.sights.repository.SightsRepository
import org.bson.types.ObjectId
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
import java.io.FileReader

@RunWith(SpringRunner::class)
@SpringBootTest
class SightsApiControllerTests {

    @Autowired
    private lateinit var sightsApiController: SightsApiController

    @Autowired
    private lateinit var sightsRepository: SightsRepository

    private val gson = Gson()

    private val sightsCollectionFilepath = "src/test/kotlin/io/valternep/sights/integration/examples/Sight.json"

    private val listOfSights = gson.fromJson<List<Sight>>(
        FileReader(sightsCollectionFilepath),
        object : TypeToken<List<Sight>>() {}.type
    )

    @Before
    fun setUp() {
        sightsRepository.deleteAll()
        listOfSights.forEach { sightsRepository.save(it) }
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

    @Test
    fun `GET to sights detail endpoint`() {
        val sightId = "59c43d27dd5e3d0a02433b4c"
        val mockMvc = MockMvcBuilders.standaloneSetup(sightsApiController)
            .apply<StandaloneMockMvcBuilder>(SharedHttpSessionConfigurer.sharedHttpSession())
            .build()

        mockMvc.perform(get("/sights/$sightId"))
            .andExpect(status().isOk)
            .andExpect(content().json(gson.toJson(sightsRepository.findById(ObjectId(sightId)))))
    }
}