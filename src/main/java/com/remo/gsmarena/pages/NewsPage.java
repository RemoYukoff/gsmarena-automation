package com.remo.gsmarena.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class NewsPage extends AbstractPage {

    @FindBy(className = "article-info-name")
    private ExtendedWebElement title;

    @FindBy(className="searchFor")
    private ExtendedWebElement searchTextField;

    @FindBy(xpath="//input[@value='Search']")
    private ExtendedWebElement searchButton;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return title.getText();
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public ExtendedWebElement getSearchTextField() {
        return searchTextField;
    }
}
