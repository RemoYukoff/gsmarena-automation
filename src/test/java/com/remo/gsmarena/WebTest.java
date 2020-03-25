package com.remo.gsmarena;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.remo.gsmarena.pages.HomePage;
import com.remo.gsmarena.pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest extends AbstractTest {
    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/user.xlsx", sheet = "GSMArena", dsUid = "TUID",
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
}
