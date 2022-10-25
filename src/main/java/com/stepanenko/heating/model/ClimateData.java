package com.stepanenko.heating.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ClimateData {

    private String buildingSite;
    private double winterOutdoorTemperature;
    private double summerOutdoorTemperature;
    private double averageTemperatureHeatingPeriod;
}
