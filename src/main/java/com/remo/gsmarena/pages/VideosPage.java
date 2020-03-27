package com.remo.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VideosPage extends AbstractPage {
    @FindBy(className = "article-info-name")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@id='ytplayer']")
    private List<ExtendedWebElement> videos;

    public VideosPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return title.getText();
    }

    public List<ExtendedWebElement> getVideos(){
        return videos;
    }
}
