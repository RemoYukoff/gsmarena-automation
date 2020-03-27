package com.remo.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.remo.gsmarena.components.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {
    @FindBy(id = "menu")
    private Menu menu;

    @FindBy(xpath = "//*[@id='header']/div/div/button")
    private ExtendedWebElement burguerButton;

    // Probably should move this to Menu component
    ///////////////////////////////////////////////////
    //The anchor is used for both functionalities, signup and logout
    @FindBy(className = "signup-icon")
    private ExtendedWebElement singupLogoutIcon;

    //Contains the username when logged in, otherwise used for login and contains text "Log in"
    @FindBy(id = "login-active")
    private ExtendedWebElement loginUserIcon;

    @FindBy(id="email")
    private ExtendedWebElement emailInput;

    @FindBy(id="upass")
    private ExtendedWebElement passwordInput;

    @FindBy(id="nick-submit")
    private ExtendedWebElement submitButton;

    @FindBy(id = "topsearch-text")
    private ExtendedWebElement searchBox;

    @FindBy(className="go")
    private ExtendedWebElement searchButton;
    ///////////////////////////////////////////////////

    // Create a login page?
    ///////////////////////////////////////////////////
    //Below elements are created just for a moment after the login
    @FindBy(className = "article-info-name")
    private ExtendedWebElement title;

    @FindBy(className = "res-error")
    private ExtendedWebElement errorText;

    @FindBy(className = "res-success")
    private ExtendedWebElement successText;
    ///////////////////////////////////////////////////

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Menu getMenu() {
        burguerButton.click();
        return menu;
    }

    public SignupPage getSignupPage(){
        singupLogoutIcon.click();
        return new SignupPage(driver);
    }

    public HomePage login(String email,String password){
        loginUserIcon.click();
        emailInput.type(email);
        passwordInput.type(password);
        submitButton.click();
        return new HomePage(driver);
    }

    public HomePage logout(){
        singupLogoutIcon.click();
        return new HomePage(driver);
    }

    public String getUserActive(){
        String user = loginUserIcon.findExtendedWebElement(By.tagName("span")).getText();
        return user;
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

    public SearchPage search(String searchText){
        searchBox.type(searchText);
        searchButton.click();
        return new SearchPage(driver);
    }
}
