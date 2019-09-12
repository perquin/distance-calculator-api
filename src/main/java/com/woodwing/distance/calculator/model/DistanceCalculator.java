package com.woodwing.distance.calculator.model;

/**
 * Distance calculator conversion related functionality.
 *
 * Created by Richard Hoquee 12/09/2019
 */
public class DistanceCalculator extends DefaultDistanceCalculator {

    private String responseDistanceUnit;

    public DistanceCalculator(String firstDistance, String firstDistanceUnit,
                              String secondDistance, String secondDistanceUnit,
                              String distanceUnit) {
        super(firstDistance, firstDistanceUnit, secondDistance, secondDistanceUnit);
        this.responseDistanceUnit = distanceUnit;
    }

    @Override
    public CalculateDistanceResponse doDistanceConversion() {

        CalculateDistanceResponse response = new CalculateDistanceResponse();

        float calculatedDistance;
        float calculatedFirstDistance;
        float calculatedSecondDistance;

        calculatedFirstDistance = doCalculateDistance(firstDistanceAmount, firstDistanceUnit);
        calculatedSecondDistance = doCalculateDistance(secondDistanceAmount, secondDistanceUnit);
        calculatedDistance = calculatedFirstDistance + calculatedSecondDistance;

        response.setCalculatedDistance(calculatedDistance);
        response.setDistanceUnit(responseDistanceUnit);

        return response;
    }

    private float doCalculateDistance(float distanceAmount, String distanceUnit) {
        float calculatedDistance = 0.0f;

        if(!distanceUnit.equals(responseDistanceUnit)) {
            if(distanceUnit == DistanceUnit.Yards.name()) {
                calculatedDistance = calculateDistanceMetres(distanceAmount);
            } else {
                calculatedDistance = calculateDistanceYards(distanceAmount);
            }
        } else {
            calculatedDistance = distanceAmount;
        }

        return calculatedDistance;


    }

    private float calculateDistanceYards(float distance) {
        return distance * METRES_YARDS_CONVERSION_FACTOR;
    }

    private float calculateDistanceMetres(float distance) {
        return distance / METRES_YARDS_CONVERSION_FACTOR;
    }

}
