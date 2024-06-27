package com.ivan.spring.selenium.page.google;

import com.ivan.spring.selenium.kelvin.annotation.Page;
import com.ivan.spring.selenium.page.Base;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

    @Getter
    @Autowired
    private SearchComponent searchComponent;

    @Getter
    @Autowired
    private SearchResult searchResult;

    @Value("${application.url}")
    private String url;

    public void goTo() {
        this.driver.get(url);
        this.acceptCookies();
    }

    // accept cookies method
    public void acceptCookies() {
        this.searchComponent.acceptCookies();
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void close() {
        this.driver.quit();
    }


}
