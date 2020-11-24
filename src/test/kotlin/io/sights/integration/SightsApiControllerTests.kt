package io.sights.integration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.nhaarman.mockito_kotlin.whenever
import io.sights.controller.SightsApiController
import io.sights.models.Sight
import io.sights.repository.SightsRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.util.ResourceUtils
import java.io.FileReader

@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = [SightsApiController::class])
class SightsApiControllerTests {

    @MockBean
    private lateinit var sightsRepository: SightsRepository

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    private lateinit var sights: List<Sight>

    @BeforeEach
    fun setup() {
        sights = objectMapper.readValue(FileReader(ResourceUtils.getFile("classpath:Sight.json")))
    }

    @Test
    fun `GET to sights endpoint`() {
        whenever(sightsRepository.findAll()).thenReturn(sights)

        mockMvc.perform(get("/sights"))
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(sights)))
    }
}
