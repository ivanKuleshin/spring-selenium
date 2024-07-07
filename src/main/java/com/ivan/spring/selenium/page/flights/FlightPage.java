package com.ivan.spring.selenium.page.flights;

import com.ivan.spring.selenium.kelvin.annotation.Page;
import com.ivan.spring.selenium.kelvin.annotation.TakeScreenshot;
import com.ivan.spring.selenium.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends BasePage {

    @Autowired
    private WebDriver driver;

    @FindBy(css = "nav.rlGvde a")
    private List<WebElement> elements;

    public void goTo(final String url){
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    @TakeScreenshot
    public List<String> getLabels(){
       return this.elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasLoaded() {
        return this.wait.until((d) -> !this.elements.isEmpty());
    }

}
