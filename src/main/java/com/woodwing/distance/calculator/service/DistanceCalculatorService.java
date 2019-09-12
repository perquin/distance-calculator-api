package com.woodwing.distance.calculator.service;

import com.woodwing.distance.calculator.model.CalculateDistanceResponse;
import com.woodwing.distance.calculator.model.DistanceCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service class for distance calculator conversion related functionality.
 *
 * Created by Richard Hoquee 06/09/2019
 */
@Service
public class DistanceCalculatorService  {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceCalculatorService.class);

    public CalculateDistanceResponse doCalculateDistance(String firstDistance, String firstDistanceUnit,
                                                         String secondDistance, String secondDistanceUnit,
                                                         String responseDistanceUnit) {

        CalculateDistanceResponse response;

        DistanceCalculator calculator = new DistanceCalculator(firstDistance, firstDistanceUnit, secondDistance, secondDistanceUnit, responseDistanceUnit);
        response = calculator.doDistanceConversion();

        return response;

    }

}
