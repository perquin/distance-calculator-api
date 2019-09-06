package com.woodwing.distance.calculator.controller;

import com.woodwing.distance.calculator.model.CalculateDistanceRequest;
import com.woodwing.distance.calculator.model.CalculateDistanceResponse;
import com.woodwing.distance.calculator.service.DistanceCalculatorService;
import com.woodwing.distance.calculator.service.DistanceCalculatorValidationService;
import com.woodwing.distance.calculator.service.exception.InvalidDataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;

/**
 * Test DistanceCalculatorController functionaility
 *
 * Created by Richard Hoquee 06/09/2019
 */

@RunWith(MockitoJUnitRunner.class)
public class DistanceCalculatorControllerTest {

    @Mock
    private DistanceCalculatorService mockDistanceCalculatorService;

    @Mock
    private DistanceCalculatorValidationService mockDistanceCalculatorValidationService;

    private DistanceCalculatorController distanceCalculatorController;

    private CalculateDistanceRequest calculateDistanceRequest;

    @Mock
    private CalculateDistanceResponse mockCalculateDistanceResponse;

    @Before
    public void setUp() {
        distanceCalculatorController = new DistanceCalculatorController(mockDistanceCalculatorService, mockDistanceCalculatorValidationService);
        calculateDistanceRequest = new CalculateDistanceRequest();
        calculateDistanceRequest.setFirstDistance("10");
        calculateDistanceRequest.setFirstDistanceUnit("Metres");
        calculateDistanceRequest.setSecondDistance("20");
        calculateDistanceRequest.setSecondDistanceUnit("Metres");
        calculateDistanceRequest.setResponseDistanceUnit("Metres");

    }

    @Test
    public void voidTestSendValidRequest() throws InvalidDataException {
        given(mockDistanceCalculatorService.doCalculateDistance(anyString(),anyString(),anyString(),anyString(),anyString())).willReturn(mockCalculateDistanceResponse);

        distanceCalculatorController.calculateDistance(calculateDistanceRequest);

        then(mockDistanceCalculatorValidationService).should().validateRequestDistanceData(anyString(), anyString(), anyString(), anyString(),anyString());
        then(mockDistanceCalculatorService).should().doCalculateDistance(anyString(), anyString(), anyString(), anyString(),anyString());
    }

    @Test(expected = InvalidDataException.class )
    public void voidTestSendInvalidRequest() throws InvalidDataException {
        willThrow(new InvalidDataException("First distance unit is missing"))
        .given(mockDistanceCalculatorValidationService).validateRequestDistanceData(anyString(),anyString(),anyString(),anyString(),anyString());

        distanceCalculatorController.calculateDistance(calculateDistanceRequest);

        then(mockDistanceCalculatorValidationService).should().validateRequestDistanceData(anyString(), anyString(), anyString(), anyString(),anyString());
        then(mockDistanceCalculatorService).should(never()).doCalculateDistance(anyString(), anyString(), anyString(), anyString(),anyString());
    }

}
