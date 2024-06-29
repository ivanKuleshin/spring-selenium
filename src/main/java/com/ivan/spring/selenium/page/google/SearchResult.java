package com.ivan.spring.selenium.page.google;

import com.ivan.spring.selenium.kelvin.annotation.PageFragment;
import com.ivan.spring.selenium.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends BasePage {

    @FindBy(css = "div.g")
    private List<WebElement> results;

    public int getCount(){
        return this.results.size();
    }

    @Override
    public boolean hasLoaded() {
        return this.wait.until((d) -> !this.results.isEmpty());
    }

}
