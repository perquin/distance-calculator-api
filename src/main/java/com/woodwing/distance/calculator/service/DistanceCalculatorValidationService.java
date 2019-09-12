package com.woodwing.distance.calculator.service;

import com.woodwing.distance.calculator.model.CalculateDistanceRequest;
import com.woodwing.distance.calculator.model.CalculateDistanceResponse;
import com.woodwing.distance.calculator.model.DistanceUnit;
import com.woodwing.distance.calculator.service.exception.InvalidDataException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service class for distance calculator validation related functionality.
 *
 * Created by Richard Hoquee 06/09/2019
 */

@Service
public class DistanceCalculatorValidationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceCalculatorValidationService.class);

    public void validateRequestDistanceData(String firstDistance, String firstDistanceUnit,
                                            String secondDistance, String secondDistanceUnit,
                                            String responseDistanceUnit) throws InvalidDataException {
        if(StringUtils.isEmpty(firstDistanceUnit)) {
            LOGGER.warn("First distance unit is empty");
            throw new InvalidDataException("First distance unit is missing");
        }

        if(!NumberUtils.isParsable(firstDistance)) {
            LOGGER.warn("First distance amount is invalid");
            throw new InvalidDataException("First distance number is missing");
        }

        if(StringUtils.isEmpty(secondDistanceUnit)) {
            LOGGER.warn("Second distance unit is empty");
            throw new InvalidDataException("Second distance unit is missing");
        }

        if(!NumberUtils.isParsable(secondDistance)) {
            LOGGER.warn("Second distance amount is invalid");
            throw new InvalidDataException("Second distance number is missing");
        }

        if((firstDistanceUnit != DistanceUnit.Metres.name()) &&
                (firstDistanceUnit != DistanceUnit.Yards.name())) {
            LOGGER.warn("First distance unit is invalid");
            throw new InvalidDataException("First distance unit is invalid");
        }

        if((secondDistanceUnit != DistanceUnit.Metres.name()) &&
                (secondDistanceUnit != DistanceUnit.Yards.name())) {
            LOGGER.warn("Second distance unit is invalid");
            throw new InvalidDataException("Second distance unit is invalid");
        }

        if((responseDistanceUnit != DistanceUnit.Metres.name()) &&
                (responseDistanceUnit != DistanceUnit.Yards.name())) {
            LOGGER.warn("Response distance unit is invalid");
            throw new InvalidDataException("Response distance unit is invalid");
        }
    }
}
