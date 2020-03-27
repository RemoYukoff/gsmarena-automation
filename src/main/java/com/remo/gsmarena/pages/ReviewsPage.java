package com.remo.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReviewsPage extends AbstractPage {
    @FindBy(className = "article-info-name")
    private ExtendedWebElement title;

    @FindBy(className="searchFor")
    private ExtendedWebElement searchTextField;

    @FindBy(xpath="//input[@value='Search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//*[@id='reviews']/div/div/div[1]")
    private List<ExtendedWebElement> reviews;

    public ReviewsPage(WebDriver driver) {
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

    public List<ExtendedWebElement> getReviews(){
        return reviews;
    }
}
