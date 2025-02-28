package com.ivan.spring.selenium.page.window;

import com.ivan.spring.selenium.kelvin.annotation.Window;
import com.ivan.spring.selenium.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page B")
public class PageB  extends BasePage {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg){
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean hasLoaded() {
        return this.wait.until((d) -> this.textArea.isDisplayed());
    }

}
