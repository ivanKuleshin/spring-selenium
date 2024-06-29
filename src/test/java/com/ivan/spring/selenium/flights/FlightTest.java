package com.ivan.spring.selenium.flights;

import com.ivan.spring.selenium.SpringBaseTestNGTest;
import com.ivan.spring.selenium.page.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTest extends SpringBaseTestNGTest {

    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest(){
        this.flightPage.goTo(this.appDetails.getUrl());
        Assert.assertTrue(this.flightPage.hasLoaded());
        Assert.assertEquals(this.flightPage.getLabels(), this.appDetails.getLabels());
    }

}
