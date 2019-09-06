package com.woodwing.distance.calculator.model;

public class CalculateDistanceRequest {

    private String firstDistance;

    private String firstDistanceUnit;

    private String secondDistance;

    private String secondDistanceUnit;

    private String responseDistanceUnit;

    public String getFirstDistance() {
        return firstDistance;
    }

    public void setFirstDistance(String firstDistance) {
        this.firstDistance = firstDistance;
    }

    public String getFirstDistanceUnit() {
        return firstDistanceUnit;
    }

    public void setFirstDistanceUnit(String firstDistanceUnit) {
        this.firstDistanceUnit = firstDistanceUnit;
    }

    public String getSecondDistance() {
        return secondDistance;
    }

    public void setSecondDistance(String secondDistance) {
        this.secondDistance = secondDistance;
    }

    public String getSecondDistanceUnit() {
        return secondDistanceUnit;
    }

    public void setSecondDistanceUnit(String secondDistanceUnit) {
        this.secondDistanceUnit = secondDistanceUnit;
    }

    public String getResponseDistanceUnit() {
        return responseDistanceUnit;
    }

    public void setResponseDistanceUnit(String responseDistanceUnit) {
        this.responseDistanceUnit = responseDistanceUnit;
    }
}
