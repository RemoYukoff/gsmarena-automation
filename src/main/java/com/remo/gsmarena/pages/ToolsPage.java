package com.remo.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ToolsPage extends AbstractPage {
    @FindBy(className = "article-info-name")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@id='lab-list']/li/a/h3")
    private List<ExtendedWebElement> toolsName;

    public ToolsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return title.getText();
    }

    public  List<String> getToolsName(){
        return toolsName.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }
}
