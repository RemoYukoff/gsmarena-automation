package com.remo.gsmarena;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.remo.gsmarena.pages.HomePage;
import com.remo.gsmarena.pages.SearchPage;
import com.remo.gsmarena.pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class WebTest extends AbstractTest {
    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/data.xlsx", sheet = "registration", dsUid = "TUID",
            dsArgs = "username, password, email, success")
    public void registration(String username, String password, String email, String success) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected("https://www.gsmarena.com"),
                "Home page is not opened");

        SignupPage signupPage = homePage.getSignupPage();
        Assert.assertTrue(signupPage.isUrlAsExpected("https://www.gsmarena.com/register.php3"),
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
        Assert.assertTrue(homePage.isUrlAsExpected("https://www.gsmarena.com"),
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
        Assert.assertTrue(homePage.isUrlAsExpected("https://www.gsmarena.com"),
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
        Assert.assertTrue(homePage.isUrlAsExpected("https://www.gsmarena.com"),
                "Home page is not opened");

        searchText = searchText.toLowerCase();
        SearchPage searchPage = homePage.search(searchText);
        List<String> phones = searchPage.getPhonesName();

        String finalSearchText = searchText;
        float sum = phones.stream().map(phone -> phone.contains(finalSearchText) ? 1f : 0f).reduce(Float::sum).get();
        float mean = sum / phones.size();
        Assert.assertTrue(mean >= 0.8, "Less than 80% of the items contains the keyword " + searchText);
    }
}
