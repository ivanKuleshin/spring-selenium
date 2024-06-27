package com.ivan.spring.selenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.udemy.spring.springselenium.bdd",
        tags =  "@visa",
        plugin = {
                "pretty",
                "html:target/index.html"
        }
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
