package com.remo.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.remo.gsmarena.components.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePage extends AbstractPage {
    @FindBy(id = "menu")
    private Menu menu;

    @FindBy(className = "signup-icon")
    private ExtendedWebElement signupLink;

    @FindBy(id = "login-active")
    private ExtendedWebElement loginButton;

    @FindBy(id="email")
    private ExtendedWebElement emailInput;

    @FindBy(id="upass")
    private ExtendedWebElement passwordInput;

    @FindBy(id="nick-submit")
    private ExtendedWebElement submitButton;

    //Below elements are created just for a moment after the login
    @FindBy(className = "article-info-name")
    private ExtendedWebElement title;

    @FindBy(className = "res-error")
    private ExtendedWebElement errorText;

    @FindBy(className = "res-success")
    private ExtendedWebElement successText;

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

    public void login(String email,String password){
        loginButton.click();
        emailInput.type(email);
        passwordInput.type(password);
        submitButton.click();
    }

    public String getTitle(){
        return title.getText();
    }

    public String getErrorText() {
        return errorText.findExtendedWebElement(By.tagName("h3")).getText();
    }

    public String getSuccessText() {
        return successText.findExtendedWebElement(By.tagName("h3")).getText();
    }
}
