package testsPhptravels.loginTests;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsPhptravels.base.BaseTest;
import web.components.Header;
import web.pages.HomePage;
import web.pages.LoginPage;
import web.utils.enums.CurrencyEnum;
import web.utils.enums.LanguagesEnum;

public class LoginTests extends BaseTest {

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckLoginIsNotWorkWithoutData() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        header.openLoginMenu();
        LoginPage logInPage = header.goToLoginPage();
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
        header.openLoginMenu();
        LoginPage logInPage = header.goToLoginPage();
        Assert.assertTrue(logInPage.isOpened(), "Login page isn't open");
        logInPage.fillEmailForm(R.TESTDATA.get("TEST_USER"));
        logInPage.fillPasswordForm(R.TESTDATA.get("TEST_PASSWORD"));
        logInPage.clickLoginButton();
        Assert.assertTrue(logInPage.isOpened(), "Login isn't success");
    }

}
