package com.remo.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends AbstractPage {
    @FindBy(className = "article-info-name")
    private ExtendedWebElement title;

    @FindBy(xpath="//form[@id='frmOpin']//*[@id='uname']")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath="//form[@id='frmOpin']//*[@id='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath="//form[@id='frmOpin']//*[@id='upass']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath="//form[@id='frmOpin']//label[@for='iagree1']")
    private ExtendedWebElement storeDataCheckbox;

    @FindBy(xpath="//form[@id='frmOpin']//label[@for='iagree2']")
    private ExtendedWebElement ageCheckbox;

    @FindBy(xpath="//form[@id='frmOpin']//*[@type='submit']")
    private ExtendedWebElement submitButton;

    @FindBy(className = "res-error")
    private ExtendedWebElement errorText;

    @FindBy(className = "res-success")
    private ExtendedWebElement successText;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return title.getText();
    }

    public void signup(String username,String email,String password){
        usernameInput.type(username);
        emailInput.type(email);
        passwordInput.type(password);
        storeDataCheckbox.click();
        ageCheckbox.click();
        submitButton.click();
    }

    public String getErrorText() {
        return errorText.findExtendedWebElement(By.tagName("h3")).getText();
    }

    public String getSuccessText() {
        return successText.findExtendedWebElement(By.tagName("h3")).getText();
    }
}
