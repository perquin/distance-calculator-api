package com.woodwing.distance.calculator.controller;

import com.woodwing.distance.calculator.model.CalculateDistanceRequest;
import com.woodwing.distance.calculator.model.CalculateDistanceResponse;
import com.woodwing.distance.calculator.service.DistanceCalculatorService;
import com.woodwing.distance.calculator.service.DistanceCalculatorValidationService;
import com.woodwing.distance.calculator.service.exception.InvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Distance calculator related functionality.
 *
 * Created by Richard Hoquee 12/09/2019
 */
@RestController
@RequestMapping("/api")
public class DistanceCalculatorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceCalculatorController.class);

    private final DistanceCalculatorService distanceCalculatorService;

    private final DistanceCalculatorValidationService distanceCalculatorValidationService;


    @Autowired
    public DistanceCalculatorController(DistanceCalculatorService distanceCalculatorService,
                                        DistanceCalculatorValidationService distanceCalculatorValidationService) {
        this.distanceCalculatorService = distanceCalculatorService;
        this.distanceCalculatorValidationService = distanceCalculatorValidationService;
    }

    @RequestMapping(path = "/distancecalculator", method = RequestMethod.POST)
    public CalculateDistanceResponse calculateDistance(@RequestBody CalculateDistanceRequest body) throws InvalidDataException {
        LOGGER.info("Request distance calculation in{}", body.getResponseDistanceUnit());

        distanceCalculatorValidationService.validateRequestDistanceData(body.getFirstDistance(),
                body.getFirstDistanceUnit(),
                body.getSecondDistance(),
                body.getSecondDistanceUnit(),
                body.getResponseDistanceUnit());

        return distanceCalculatorService.doCalculateDistance(body.getFirstDistanceUnit(),
                body.getFirstDistance(),
                body.getSecondDistanceUnit(),
                body.getSecondDistance(),
                body.getResponseDistanceUnit());
    }


}
