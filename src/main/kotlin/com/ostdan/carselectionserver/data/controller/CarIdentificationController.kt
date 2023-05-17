package com.ostdan.carselectionserver.data.controller

import com.ostdan.carselectionserver.data.model.CheckSessionResponse
import com.ostdan.carselectionserver.data.service.CarIdentificationService
import com.ostdan.carselectionserver.domain.model.User
import com.ostdan.carselectionserver.log.Logging
import com.ostdan.carselectionserver.log.logger
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/car")
class CarIdentificationController(
    val service: CarIdentificationService
) : Logging {

    @GetMapping("/vin")
    fun getCarByVIN(
        @RequestParam("searchQuery") searchQuery: String,
        @RequestParam("userId") userId: String
    ): CheckSessionResponse {
        logger().info("{} produces \"getCarByVIN\" with searchQuery=\'{}\'", userId, searchQuery)
        return service.getCarByVIN(searchQuery, userId)
    }

    /*@GetMapping("/number") TODO: Ищем API для предоставления VIN по гос. номеру
    fun getCarByGovNumber(@RequestParam searchQuery: String) {
        logger().info("\"getCarByGovNumber\" with searchQuery=\'{}\'", searchQuery)
        return service.getCarByGovNumber(searchQuery)
    }*/
}