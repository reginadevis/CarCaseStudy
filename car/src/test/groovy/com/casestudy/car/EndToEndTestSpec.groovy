package com.casestudy.car

import com.casestudy.controller.CarController
import com.casestudy.repository.CarRepository
import com.casestudy.service.CarService
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@AutoConfigureMockMvc
class EndToEndTestSpec extends Specification{
    @Autowired
    MockMvc mockMvc

    @Autowired
    CarRepository carRepository

    @Autowired
    CarService carService

    def 'testDBCheck'() {

        given: def inputid = 4

        when: 'try mockmvc'

        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/car/5")))
                .andExpect(MockMvcResultMatchers.status().isOk())


        then:
        noExceptionThrown()
    }
}
