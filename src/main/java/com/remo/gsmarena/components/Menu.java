/*
 * Copyright 2013-2020 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.remo.gsmarena.components;

import com.remo.gsmarena.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class Menu extends AbstractUIObject {
    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    @FindBy(linkText = "Reviews")
    private ExtendedWebElement reviewsLink;

    @FindBy(linkText = "Videos")
    private ExtendedWebElement videosLink;

    @FindBy(linkText = "Featured")
    private ExtendedWebElement featuredLink;

    @FindBy(linkText = "Phone Finder")
    private ExtendedWebElement phoneFinderLink;

    @FindBy(linkText = "Tools")
    private ExtendedWebElement toolsLink;

    @FindBy(linkText = "Glossary")
    private ExtendedWebElement glossaryLink;

    @FindBy(linkText = "Coverage")
    private ExtendedWebElement coverageLink;

    @FindBy(linkText = "Contact")
    private ExtendedWebElement contactLink;

    public Menu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

//    public NewsPage openNewsPage() {
//        newsLink.click();
//        return new NewsPage(driver);
//    }
//
//    public ReviewsPage openReviewsPage() {
//        reviewsLink.click();
//        return new ReviewsPage(driver);
//    }
//
//    public VideosPage openVideosPage() {
//        videosLink.click();
//        return new VideosPage(driver);
//    }
//
//    public NewsPage openFeaturedPage() {
//        featuredLink.click();
//        return new NewsPage(driver);
//    }
//
//    public PhoneFinderPage openPhoneFinderPage() {
//        phoneFinderLink.click();
//        return new PhoneFinderPage(driver);
//    }
//
//    public ToolsPage openToolsPage() {
//        toolsLink.click();
//        return new ToolsPage(driver);
//    }
//
//    public GlossaryPage openGlossaryPage() {
//        glossaryLink.click();
//        return new GlossaryPage(driver);
//    }

    public CoveragePage openCoveragePage() {
        coverageLink.click();
        return new CoveragePage(driver);
    }

    public ContactPage openContactPage() {
        contactLink.click();
        return new ContactPage(driver);
    }
}
