package com.ivan.spring.selenium.googletest;

import com.ivan.spring.selenium.SpringBaseTestNGTest;
import com.ivan.spring.selenium.kelvin.annotation.LazyAutowired;
import com.ivan.spring.selenium.kelvin.service.ScreenshotService;
import com.ivan.spring.selenium.page.google.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google1Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleTest()  {
        this.googlePage.open();
        this.googlePage.getSearchComponent().search("spring boot");

        Assert.assertTrue(this.googlePage.getSearchResult().hasLoaded());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        screenshotService.takeScreenShot();
    }

}
