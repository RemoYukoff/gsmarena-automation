package com.remo.gsmarena.components;

import com.remo.gsmarena.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class Menu extends AbstractUIObject {
    @FindBy(xpath = ".//a[text()='Home']")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = ".//a[text()='News']")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = ".//a[text()='Reviews']")
    private ExtendedWebElement reviewsLink;

    @FindBy(xpath = ".//a[text()='Videos']")
    private ExtendedWebElement videosLink;

    @FindBy(xpath = ".//a[text()='Featured']")
    private ExtendedWebElement featuredLink;

    @FindBy(xpath = ".//a[text()='Phone Finder']")
    private ExtendedWebElement phoneFinderLink;

    @FindBy(xpath = ".//a[text()='Tools']")
    private ExtendedWebElement toolsLink;

    @FindBy(xpath = ".//a[text()='Glossary']")
    private ExtendedWebElement glossaryLink;

    @FindBy(xpath = ".//a[text()='Coverage']")
    private ExtendedWebElement coverageLink;

    @FindBy(xpath = ".//a[text()='Contact']")
    private ExtendedWebElement contactLink;

    public Menu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public NewsPage openNewsPage() {
        newsLink.click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        reviewsLink.click();
        return new ReviewsPage(driver);
    }

    public VideosPage openVideosPage() {
        videosLink.click();
        return new VideosPage(driver);
    }

    public NewsPage openFeaturedPage() {
        featuredLink.click();
        return new NewsPage(driver);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        phoneFinderLink.click();
        return new PhoneFinderPage(driver);
    }

    public ToolsPage openToolsPage() {
        toolsLink.click();
        return new ToolsPage(driver);
    }

    public GlossaryPage openGlossaryPage() {
        glossaryLink.click();
        return new GlossaryPage(driver);
    }

    public CoveragePage openCoveragePage() {
        coverageLink.click();
        return new CoveragePage(driver);
    }

    public ContactPage openContactPage() {
        contactLink.click();
        return new ContactPage(driver);
    }
}
