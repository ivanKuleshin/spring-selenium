package com.ivan.spring.selenium;

import com.ivan.spring.selenium.kelvin.service.ScreenshotService;
import com.ivan.spring.selenium.listeners.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@SpringBootTest
@Listeners(ScreenshotListener.class)
public class SpringBaseTestNGTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebDriver driver;

    @Autowired
    private static ScreenshotService screenshotService;

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

//    @BeforeTest
//    public void clearScreenshotFolder() {
//        screenshotService.clearScreenshotFolder();
//    }
}
