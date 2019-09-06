package com.woodwing.distance.calculator.model;

public class CalculateDistanceResponse {

    private float calculatedDistance;

    private String distanceUnit;

    public float getCalculatedDistance() {
        return calculatedDistance;
    }

    public void setCalculatedDistance(float calculatedDistance) {
        this.calculatedDistance = calculatedDistance;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }
}
