package com.woodwing.distance.calculator.service;

import com.woodwing.distance.calculator.service.exception.InvalidDataException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test DistanceCalculator Validation Service functionaility.
 *
 * Created by Richard Hoquee 06/09/2019
 */

@RunWith(MockitoJUnitRunner.class)
public class DistanceCalculatorValidationServiceTest {

    private DistanceCalculatorValidationService distanceCalculatorValidationService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {distanceCalculatorValidationService = new DistanceCalculatorValidationService();}

    @Test
    public void testDistanceCalculationValuesAreValid() throws InvalidDataException {
        distanceCalculatorValidationService.validateRequestDistanceData("10.5","Yards","10.5", "Yards", "Metres");
    }

    @Test
    public void testDistanceCalculationFirstDistanceEmpty() throws InvalidDataException {
        expectedException.expect(InvalidDataException.class);
        distanceCalculatorValidationService.validateRequestDistanceData("","Yards","10.5", "Yards", "Metres");
    }

    @Test
    public void testDistanceCalculationFirstDistanceUnitEmpty() throws InvalidDataException {
        expectedException.expect(InvalidDataException.class);
        distanceCalculatorValidationService.validateRequestDistanceData("10.5","","10.5", "Yards", "Metres");
    }

    @Test
    public void testDistanceCalculationSecondDistanceEmpty() throws InvalidDataException {
        expectedException.expect(InvalidDataException.class);
        distanceCalculatorValidationService.validateRequestDistanceData("10.5","Yards","", "Yards", "Metres");
    }

    @Test
    public void testDistanceCalculationSecondDistanceUnitEmpty() throws InvalidDataException {
        expectedException.expect(InvalidDataException.class);
        distanceCalculatorValidationService.validateRequestDistanceData("10.5","Yards","10.5", "", "Metres");
    }

    @Test
    public void testDistanceCalculationResponseUnitEmpty() throws InvalidDataException {
        expectedException.expect(InvalidDataException.class);
        distanceCalculatorValidationService.validateRequestDistanceData("10.5","Yards","10.5", "Yards", "");
    }


}
