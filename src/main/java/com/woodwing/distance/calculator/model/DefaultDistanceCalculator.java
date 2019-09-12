package com.woodwing.distance.calculator.model;

/**
 * Base class for distance calculator conversion related functionality.
 *
 * Created by Richard Hoquee 12/09/2019
 */
public abstract class DefaultDistanceCalculator {

    protected static final float METRES_YARDS_CONVERSION_FACTOR = 1.0936f;

    protected float firstDistanceAmount;
    protected String firstDistanceUnit;
    protected float secondDistanceAmount;
    protected String secondDistanceUnit;

    public DefaultDistanceCalculator(String firstDistance,
                              String firstDistanceUnit,
                              String secondDistance,
                              String secondDistanceUnit) {

        this.firstDistanceAmount = Float.parseFloat(firstDistance);
        this.firstDistanceUnit = firstDistanceUnit;
        this.secondDistanceAmount = Float.parseFloat(secondDistance);
        this.secondDistanceUnit = secondDistanceUnit;
    }

    public abstract CalculateDistanceResponse doDistanceConversion();


}
