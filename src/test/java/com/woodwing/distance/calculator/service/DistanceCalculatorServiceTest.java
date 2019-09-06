package com.woodwing.distance.calculator.service;

import com.woodwing.distance.calculator.model.CalculateDistanceResponse;
import com.woodwing.distance.calculator.model.DistanceUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test DistanceCalculator Service functionaility
 *
 * Created by Richard Hoquee 06/09/2019
 */

@RunWith(MockitoJUnitRunner.class)
public class DistanceCalculatorServiceTest {

    private DistanceCalculatorService distanceCalculatorService;

    @Before
    public void setUp() {distanceCalculatorService = new DistanceCalculatorService();}

    @Test
    public void testConvertBothParametersYardsToMetresIsValid() {
        CalculateDistanceResponse response = distanceCalculatorService.doCalculateDistance("10.5","Yards","10.5", "Yards", "Metres");

        Assert.assertEquals(19.20, response.getCalculatedDistance(),0.1f);
        Assert.assertTrue(DistanceUnit.Metres.name() == response.getDistanceUnit());

    }

    @Test
    public void testConvertParametersMetresYardsToMetresIsValid() {
        CalculateDistanceResponse response = distanceCalculatorService.doCalculateDistance("10.5","Metres","10.5", "Yards", "Metres");

        Assert.assertEquals(20.10, response.getCalculatedDistance(),0.1f);
        Assert.assertTrue(DistanceUnit.Metres.name() == response.getDistanceUnit());

    }

    @Test
    public void testConvertBothParametersMetresToYardsIsValid() {
        CalculateDistanceResponse response = distanceCalculatorService.doCalculateDistance("10.5","Metres","10.5", "Metres", "Yards");

        Assert.assertEquals(22.96, response.getCalculatedDistance(),0.1f);
        Assert.assertTrue(DistanceUnit.Yards.name() == response.getDistanceUnit());

    }

    @Test
    public void testConvertParametersYardsMetresToYardsIsValid() {
        CalculateDistanceResponse response = distanceCalculatorService.doCalculateDistance("10.5","Yards","10.5", "Metres", "Yards");

        Assert.assertEquals(21.98, response.getCalculatedDistance(),0.1f);
        Assert.assertTrue(DistanceUnit.Yards.name() == response.getDistanceUnit());

    }


}
