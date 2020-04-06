package com.remo.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends AbstractPage {
    @FindBy(xpath="//*[@id='review-body']/div/ul//li/a/strong/span")
    private List<ExtendedWebElement> phones;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getPhonesName(){
        return phones.stream().map(ExtendedWebElement::getText).map(String::toLowerCase).collect(Collectors.toList());
    }
}
