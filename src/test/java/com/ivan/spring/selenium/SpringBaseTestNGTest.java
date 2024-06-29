package com.ivan.spring.selenium;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;

@SpringBootTest
public class SpringBaseTestNGTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WebDriver driver;

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
