package com.woodwing.distance.calculator.service;

import com.woodwing.distance.calculator.model.CalculateDistanceResponse;
import com.woodwing.distance.calculator.model.DistanceUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for distance calculator conversion related functionality.
 *
 * Created by Richard Hoquee 06/09/2019
 */
public class DistanceCalculatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceCalculatorService.class);

    private static final float TO_METRES_CONVERSION_FACTOR = 1.0936f;

    public CalculateDistanceResponse doCalculateDistance(String firstDistance, String firstDistanceUnit,
                                                         String secondDistance, String secondDistanceUnit,
                                                         String responseDistanceUnit) {

        CalculateDistanceResponse response;
        if(responseDistanceUnit == DistanceUnit.Metres.name()) {
            response = doConvertToMetres(firstDistance, firstDistanceUnit,
                    secondDistance, secondDistanceUnit, responseDistanceUnit);
        } else {
            response = doConvertToYards(firstDistance, firstDistanceUnit,
                    secondDistance, secondDistanceUnit, responseDistanceUnit);
        }

        return response;

    }

    private CalculateDistanceResponse doConvertToMetres(String firstDistance, String firstDistanceUnit,
                              String secondDistance, String secondDistanceUnit,
                              String responseDistanceUnit) {

        float calculatedDistanceMetres;
        float calculatedFirstDistanceMetres = 0.0f;
        float calculatedSecondDistanceMetres = 0.0f;
        float firstDistanceAmount = Float.parseFloat(firstDistance);
        float secondDistanceAmount = Float.parseFloat(secondDistance);

        CalculateDistanceResponse response = new CalculateDistanceResponse();
        response.setDistanceUnit(responseDistanceUnit);

        if ((firstDistanceUnit == DistanceUnit.Metres.name()) &&
                (secondDistanceUnit == DistanceUnit.Metres.name())) {
            calculatedDistanceMetres = firstDistanceAmount + secondDistanceAmount;
            response.setCalculatedDistance(calculatedDistanceMetres);
            response.setDistanceUnit(responseDistanceUnit);
            return response;
        }

        if(firstDistanceUnit == DistanceUnit.Yards.name()) {
            calculatedFirstDistanceMetres = calculateToMetres(firstDistanceAmount);
        }

        if(secondDistanceUnit == DistanceUnit.Yards.name()) {
            calculatedSecondDistanceMetres = calculateToMetres(secondDistanceAmount);
        }

        if(firstDistanceUnit == DistanceUnit.Metres.name() &&
                secondDistanceUnit == DistanceUnit.Yards.name()) {
            calculatedDistanceMetres = firstDistanceAmount + calculatedSecondDistanceMetres;
            response.setCalculatedDistance(calculatedDistanceMetres);

        } else if(firstDistanceUnit == DistanceUnit.Yards.name() &&
                secondDistanceUnit == DistanceUnit.Metres.name()) {

            calculatedDistanceMetres = calculatedFirstDistanceMetres + secondDistanceAmount;
            response.setCalculatedDistance(calculatedDistanceMetres);
        } else {
            calculatedDistanceMetres = calculatedFirstDistanceMetres + calculatedSecondDistanceMetres;
            response.setCalculatedDistance(calculatedDistanceMetres);
        }

        return response;
    }

    private float calculateToMetres(float distanceYards) {
        return distanceYards / TO_METRES_CONVERSION_FACTOR;
    }

    private CalculateDistanceResponse doConvertToYards(String firstDistance, String firstDistanceUnit,
                                                        String secondDistance, String secondDistanceUnit,
                                                        String responseDistanceUnit) {
        float calculatedDistanceYards;
        float calculatedFirstDistanceYards = 0.0f;
        float calculatedSecondDistanceYards = 0.0f;
        float firstDistanceAmount = Float.parseFloat(firstDistance);
        float secondDistanceAmount = Float.parseFloat(secondDistance);

        CalculateDistanceResponse response = new CalculateDistanceResponse();
        response.setDistanceUnit(responseDistanceUnit);

        if ((firstDistanceUnit == DistanceUnit.Yards.name()) &&
                (secondDistanceUnit == DistanceUnit.Yards.name())) {
            calculatedDistanceYards = firstDistanceAmount + secondDistanceAmount;
            response.setCalculatedDistance(calculatedDistanceYards);
            response.setDistanceUnit(responseDistanceUnit);
            return response;
        }

        if(firstDistanceUnit == DistanceUnit.Metres.name()) {
            calculatedFirstDistanceYards = calculateToYards(firstDistanceAmount);
        }

        if(secondDistanceUnit == DistanceUnit.Metres.name()) {
            calculatedSecondDistanceYards = calculateToYards(secondDistanceAmount);
        }

        if(firstDistanceUnit == DistanceUnit.Yards.name() &&
                secondDistanceUnit == DistanceUnit.Metres.name()) {
            calculatedDistanceYards = firstDistanceAmount + calculatedSecondDistanceYards;
            response.setCalculatedDistance(calculatedDistanceYards);

        } else if(firstDistanceUnit == DistanceUnit.Metres.name() &&
                secondDistanceUnit == DistanceUnit.Yards.name()) {

            calculatedDistanceYards = calculatedFirstDistanceYards + secondDistanceAmount;
            response.setCalculatedDistance(calculatedDistanceYards);
        } else {
            calculatedDistanceYards = calculatedFirstDistanceYards + calculatedSecondDistanceYards;
            response.setCalculatedDistance(calculatedDistanceYards);
        }

        return response;

    }

    private float calculateToYards(float distanceMetres) {
        return distanceMetres * TO_METRES_CONVERSION_FACTOR;
    }


}
