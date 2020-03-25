package com.remo.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.remo.gsmarena.components.Menu;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePage extends AbstractPage {
    @FindBy(id = "menu")
    private Menu menu;

    @FindBy(className = "signup-icon")
    private ExtendedWebElement signupLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Menu getMenu() {
        return menu;
    }

    public SignupPage getSignupPage(){
        signupLink.click();
        return new SignupPage(driver);
    }
}
