//package com.remo.gsmarena.pages;
//
//import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
//import com.qaprosoft.carina.core.gui.AbstractPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;
//
//public class ToolsPage extends AbstractPage {
//    @FindBy(className = "article-info-name")
//    private ExtendedWebElement title;
//
//    @FindBy(className = "st-text")
//    private ExtendedWebElement info;
//
//    public ContactPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public String getTitle(){
//        return title.getText();
//    }
//
//    public ExtendedWebElement getInfoElement(){
//        return info;
//    }
//}
