package com.ivan.spring.selenium.googletest;

import com.ivan.spring.selenium.SpringBaseTestNGTest;
import com.ivan.spring.selenium.kelvin.annotation.LazyAutowired;
import com.ivan.spring.selenium.kelvin.service.ScreenshotService;
import com.ivan.spring.selenium.page.google.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google2Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("selenium");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 10);
        this.screenshotService.takeScreenShot();
        this.googlePage.close();
    }

}
