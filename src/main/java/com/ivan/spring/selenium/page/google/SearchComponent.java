package com.ivan.spring.selenium.page.google;

import com.ivan.spring.selenium.kelvin.annotation.PageFragment;
import com.ivan.spring.selenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    @FindBy(xpath = "//h1[text()='Before you continue to Google']")
    private WebElement beforeYouContinueToGoogleHeader;

    @FindBy(xpath = "//div[text()='Accept all']/parent::button")
    private WebElement acceptAllBtn;

    public void search(final String keyword){
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtns
                .stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }

    public void acceptCookies() {
        if(beforeYouContinueToGoogleHeader.isDisplayed()){
            this.wait.until((d) -> this.acceptAllBtn.isDisplayed());
            this.acceptAllBtn.click();
        }
    }
}
