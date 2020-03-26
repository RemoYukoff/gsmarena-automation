package com.remo.gsmarena;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.remo.gsmarena.pages.HomePage;
import com.remo.gsmarena.pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        signupPage.signup(username,email,password);
        if(Boolean.parseBoolean(success)){
            String message = signupPage.getSuccessText();
            Assert.assertEquals(message, "Your account was created.");
        } else {
            String message = signupPage.getErrorText();
            Assert.assertEquals(message, "The operation failed.");
        }
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/data.xlsx", sheet = "login", dsUid = "TUID",
            dsArgs = "email, password, success")
    public void login(String email, String password, String success) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isUrlAsExpected("https://www.gsmarena.com"),
                "Home page is not opened");

        homePage.login(email, password);

        Assert.assertEquals(homePage.getTitle(), "Login result");
        if(Boolean.parseBoolean(success)){
            String message = homePage.getSuccessText();
            Assert.assertEquals(message, "Login successful.");
        } else {
            String message = homePage.getErrorText();
            Assert.assertEquals(message, "Login failed.");
        }
    }
}
