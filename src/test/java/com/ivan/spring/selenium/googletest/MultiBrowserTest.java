package com.ivan.spring.selenium.googletest;

import com.ivan.spring.selenium.SpringBaseTestNGTest;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserTest extends SpringBaseTestNGTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void browserTest(){
        this.ctx.getBean("chromeDriver", WebDriver.class).get("https://www.google.com");
        this.ctx.getBean("firefoxDriver", WebDriver.class).get("https://www.yahoo.com");
    }

}
