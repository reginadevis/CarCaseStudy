package com.casestudy.service

import com.casestudy.entity.Car
import com.casestudy.entity.Manufacturer
import com.casestudy.entity.Model
import com.casestudy.repository.CarRepository
import org.dom4j.rule.Mode
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class CarServiceSpec extends Specification{

    CarRepository carRepository = Mock(CarRepository)
    def carService = new CarService(carRepository)
    def testgetCar(){
        given:
            def expectedCar = getCarOuptut()

        when:
            def actualCar = carService.getCar(4)

        then:
            assertEquals (actualCar,expectedCar)
    }

    def getCarOuptut(){
        Car car = new Car()
        Model model = new Model()
        Manufacturer manufacturer = new Manufacturer()
        car.ID = 4
        car.color= "blue"
        car.miles=134.25
        car.vin=1246
        car.year = 2012

        model.model_id = 1
        model.model="Figo"

        manufacturer.manufacturer_id=1
        manufacturer.manufacturer="Ford"

        model.manufacturer= manufacturer
        car.model= model

        return car
    }
}
