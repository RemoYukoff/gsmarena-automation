package com.remo.gsmarena;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.remo.gsmarena.components.Menu;
import com.remo.gsmarena.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTest extends AbstractTest {
    private static final String URL = R.CONFIG.get("url");

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/data.xlsx", sheet = "registration", dsUid = "TUID",
            dsArgs = "username, password, email, success")
    public void registration(String username, String password, String email, String success) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        SignupPage signupPage = homePage.getSignupPage();
        Assert.assertTrue(signupPage.isUrlAsExpected(URL+"/register.php3"),
                "Signup page is not opened");

        Assert.assertEquals(signupPage.getTitle(), "Sign Up");
        signupPage.signup(username, email, password);
        if (Boolean.parseBoolean(success)) {
            String message = signupPage.getSuccessText();
            Assert.assertEquals(message, "Your account was created.");
        } else {
            String message = signupPage.getErrorText();
            Assert.assertEquals(message, "The operation failed.");
        }
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/data.xlsx", sheet = "login", dsUid = "TUID",
            dsArgs = "username, email, password, success")
    public void login(String username, String email, String password, String success) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        homePage = homePage.login(email, password);

        Assert.assertEquals(homePage.getTitle(), "Login result");
        if (Boolean.parseBoolean(success)) {
            String message = homePage.getSuccessText();
            Assert.assertEquals(message, "Login successful.");
            Assert.assertEquals(homePage.getUserActive(), username, "User active is incorrect");
        } else {
            String message = homePage.getErrorText();
            Assert.assertEquals(message, "Login failed.");
        }
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/data.xlsx", sheet = "login", dsUid = "TUID",
            dsArgs = "email, password")
    public void logout(String username, String email, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        homePage = homePage.login(email, password);

        Assert.assertEquals(homePage.getUserActive(), username, "User not logged in");
        homePage.logout();
        Assert.assertEquals(homePage.getUserActive(), "Log in", "The user didn't log out");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/data.xlsx", sheet = "search", dsUid = "TUID",
            dsArgs = "searchText")
    public void search(String searchText) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        searchText = searchText.toLowerCase();
        SearchPage searchPage = homePage.search(searchText);
        List<String> phones = searchPage.getPhonesName();

        String finalSearchText = searchText;
        float sum = phones.stream().map(phone -> phone.contains(finalSearchText) ? 1f : 0f).reduce(Float::sum).get();
        float mean = sum / phones.size();
        Assert.assertTrue(mean >= 0.8, "Less than 80% of the items contains the keyword " + searchText);
    }

    @Test
    public void menuContactPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        Menu menu = homePage.getMenu();
        ContactPage page = menu.openContactPage();
        Assert.assertEquals(page.getTitle(), "Contact us", "Incorrect Title");
        Assert.assertTrue(page.getInfoElement().isPresent(), "Contact info not present");
    }

    @Test
    public void menuCoveragePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        Menu menu = homePage.getMenu();
        CoveragePage page = menu.openCoveragePage();
        Assert.assertEquals(page.getTitle(), "Network coverage", "Incorrect Title");
        Assert.assertTrue(page.getCountrySelector().isClickable(), "Country selector not clickable");
    }

    @Test
    public void menuGlossaryPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        Menu menu = homePage.getMenu();
        GlossaryPage page = menu.openGlossaryPage();
        Assert.assertEquals(page.getTitle(), "Mobile terms glossary", "Incorrect Title");
        for(ExtendedWebElement link:page.getLinks()){
            Assert.assertTrue(link.isClickable(), "Glossary link not clickable");
        }
    }

    @Test
    public void menuToolsPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        Menu menu = homePage.getMenu();
        ToolsPage page = menu.openToolsPage();
        Assert.assertEquals(page.getTitle(), "GSMArena Tools & Features", "Incorrect Title");
        List<String> tools=page.getToolsName();
        Assert.assertEquals(tools.get(0),"Compare");
        Assert.assertEquals(tools.get(1),"Photo and Video Compare");
        Assert.assertEquals(tools.get(2),"Battery life table");
        Assert.assertEquals(tools.get(3),"GSMArena Labs");
        Assert.assertEquals(tools.get(4),"Coverage");
        Assert.assertEquals(tools.get(5),"FAQ");
        Assert.assertEquals(tools.get(6),"Webmaster Tools");
        Assert.assertEquals(tools.get(7),"Glossary");
    }

    @Test
    public void menuPhoneFinderPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        Menu menu = homePage.getMenu();
        PhoneFinderPage page = menu.openPhoneFinderPage();
        Assert.assertEquals(page.getTitle(), "Phone finder", "Incorrect Title");
        Assert.assertTrue(page.getPhonesTab().isClickable(),"Phones tab not clickable");
        Assert.assertTrue(page.getTabletsTab().isClickable(),"Tablets tab not clickable");
    }

    @Test
    public void menuFeaturedPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        Menu menu = homePage.getMenu();
        NewsPage page = menu.openFeaturedPage();
        Assert.assertEquals(page.getTitle(), "Articles tagged \"Featured\"", "Incorrect Title");
        page.getSearchTextField().type("test");
        Assert.assertEquals(page.getSearchTextField().getAttribute("value"),"test");
        Assert.assertTrue(page.getSearchButton().isClickable());
    }

    @Test
    public void menuVideosPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        Menu menu = homePage.getMenu();
        VideosPage page = menu.openVideosPage();
        Assert.assertEquals(page.getTitle(), "Videos", "Incorrect Title");
        for(ExtendedWebElement video:page.getVideos()){
            Assert.assertTrue(video.isVisible());
            Assert.assertTrue(video.isClickable());
        }
    }

    @Test
    public void menuReviewsPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        Menu menu = homePage.getMenu();
        ReviewsPage page = menu.openReviewsPage();
        Assert.assertEquals(page.getTitle(), "Reviews", "Incorrect Title");
        page.getSearchTextField().type("test");
        Assert.assertEquals(page.getSearchTextField().getAttribute("value"),"test");
        Assert.assertTrue(page.getSearchButton().isClickable());
        for(ExtendedWebElement review:page.getReviews()){
            Assert.assertTrue(review.isVisible());
            Assert.assertTrue(review.isClickable());
        }
    }

    @Test
    public void menuNewsPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected(URL),
                "Home page is not opened");

        Menu menu = homePage.getMenu();
        NewsPage page = menu.openNewsPage();
        Assert.assertEquals(page.getTitle(), "News", "Incorrect Title");
        page.getSearchTextField().type("test");
        Assert.assertEquals(page.getSearchTextField().getAttribute("value"),"test");
        Assert.assertTrue(page.getSearchButton().isClickable());
    }
}
