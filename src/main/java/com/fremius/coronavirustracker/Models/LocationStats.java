package com.fremius.coronavirustracker.Models;

import lombok.Data;

@Data
public class LocationStats {

    private String state;
    private String country;
    private int latestTotalCases;
    private int diffFromPreviousDay;

}
