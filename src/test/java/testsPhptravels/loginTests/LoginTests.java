package testsPhptravels.loginTests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsPhptravels.base.BaseTest;
import web.components.Header;
import web.pages.AccountPage;
import web.pages.HomePage;
import web.pages.LoginPage;
import web.pages.ProfilePage;
import web.utils.enums.CurrencyEnum;
import web.utils.enums.LanguagesEnum;
import web.utils.services.AuthenticationService;

public class LoginTests extends BaseTest {

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckLoginIsNotWorkWithoutData() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        header.clickAccountDropdown();
        LoginPage logInPage = header.clickCustomLoginButton();
        Assert.assertTrue(logInPage.isOpened(), "Login page isn't open");
        logInPage.clickLoginButton();
        Assert.assertTrue(logInPage.isOpened(), "Login is success");
    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckLoginIsWork() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        header.openBurgerMenu();
        header.clickAccountDropdown();
        LoginPage logInPage = header.clickCustomLoginButton();
        Assert.assertTrue(logInPage.isOpened(), "Login page isn't open");
        logInPage.fillEmailField(R.TESTDATA.get("TEST_USER"));
        logInPage.fillPasswordField(R.TESTDATA.get("TEST_PASSWORD"));
        logInPage.clickLoginButton();
        Assert.assertTrue(logInPage.isOpened(), "Login isn't success");
    }


    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckLogOutIsWork() {
        AccountPage accountPage = authenticationService.logIn();
        Assert.assertTrue(accountPage.isOpened(),"Account page isn't open");
        Header header = accountPage.getHeader();
        header.openBurgerMenu();
        header.clickAccountDropdown();
        LoginPage loginPage = header.clickLogOutButton();
        Assert.assertTrue(loginPage.isOpened(),"Login page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckLoginUserIsCorrect() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        header.openBurgerMenu();
        header.clickAccountDropdown();
        LoginPage logInPage = header.clickCustomLoginButton();
        Assert.assertTrue(logInPage.isOpened(), "Login page isn't open");
        logInPage.fillEmailField(R.TESTDATA.get("TEST_USER"));
        logInPage.fillPasswordField(R.TESTDATA.get("TEST_PASSWORD"));
        logInPage.clickLoginButton();
        Assert.assertTrue(logInPage.isOpened(), "Login isn't success");
        header.clickAccountDropdown();
        ProfilePage profilePage = header.clickProfileButton();
        Assert.assertEquals(profilePage.checkUserIsCorrect(),R.TESTDATA.get("TEST_USER"),"User isn't correct");
    }
}
