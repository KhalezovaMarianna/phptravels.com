package webOrangehrmlive.utils.services;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import org.testng.Assert;
import webOrangehrmlive.pages.LoginPage;
import webOrangehrmlive.pages.PimPage;

public class AuthorisationService implements IDriverPool {
    public void login() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isOpened(), "Login page isn't opened");
        loginPage.fillUsernameField("Admin");
        loginPage.fillPasswordField("admin123");
        PimPage pimPage = loginPage.clickLoginButton();
        Assert.assertTrue(pimPage.isOpened(), "PIM page isn't opened");
    }
}
