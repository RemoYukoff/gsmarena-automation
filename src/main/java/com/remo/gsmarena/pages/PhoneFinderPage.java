package com.remo.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhoneFinderPage extends AbstractPage {
    @FindBy(className = "article-info-name")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[contains(@class,'tab-tablet')]")
    private ExtendedWebElement tabletsTab;

    @FindBy(xpath = "//*[contains(@class,'tab-phone')]")
    private ExtendedWebElement phonesTab;

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return title.getText();
    }

    public ExtendedWebElement getPhonesTab(){
        return phonesTab;
    }

    public ExtendedWebElement getTabletsTab() {
        return tabletsTab;
    }
}
