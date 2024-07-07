package com.ivan.spring.selenium.page.google;

import com.ivan.spring.selenium.kelvin.annotation.Page;
import com.ivan.spring.selenium.page.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends BasePage {

    @Getter
    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private WebDriver driver;

    @Getter
    @Autowired
    private SearchResult searchResult;

    @Value("${application.url}")
    private String url;

    public void open() {
        this.driver.get(url);
        this.acceptCookies();
        hasLoaded();
    }

    // accept cookies method
    public void acceptCookies() {
        this.searchComponent.acceptCookies();
    }

    @Override
    public boolean hasLoaded() {
        return this.searchComponent.hasLoaded();
    }

    public void close() {
        this.driver.quit();
    }

}
