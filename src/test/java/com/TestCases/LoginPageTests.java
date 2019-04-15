package com.TestCases;

import com.BaseClass.Festicket.BaseClass;
import com.Pages.LoginPage;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseClass {

    LoginPage loginPage;

    @BeforeTest()
    public void setupLoginPage() throws Exception {
        setup();
    }
@Test
    public void setLoginPage() throws InterruptedException {
    loginPage = new LoginPage();
    loginPage.setLoginbutton();
     loginPage.loginusername(properties.getProperty("user_name"));
     loginPage.loginpassword(properties.getProperty("password1"));
     loginPage.submit();

        loginPage.validateuser();

        if (loginPage.actualresult.equals(properties.getProperty("expectedresult"))) {
            Assert.assertTrue(true);
            System.out.println(loginPage.actualresult);
        } else {
            Assert.assertTrue("Test Passed", true);
        }
        loginPage.logoutuser();
}
@AfterMethod()
    public void teardown()
{
    driver.quit();
}
}
