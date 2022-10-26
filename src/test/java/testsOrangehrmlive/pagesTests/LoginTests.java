package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.components.PopUpForgetPassword;
import webOrangehrmlive.pages.LoginPage;
import webOrangehrmlive.pages.PimPage;
import webOrangehrmlive.pages.loginPages.ForgetPasswordPage;
import webOrangehrmlive.utils.enums.ButtonsEnum;


public class LoginTests extends BaseTest {

    @Test
    @MethodOwner(owner = "Marianna")
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isOpened(), "Login page isn't opened");
        loginPage.fillUsernameField("Admin");
        loginPage.fillPasswordField("admin123");
        PimPage pimPage = loginPage.clickLoginButton();
        Assert.assertTrue(pimPage.isOpened(), "PIM page isn't opened");
    }

    @Test
    @MethodOwner(owner = "Maarianna")
    public void testLogout() {
        authorisationService.login();
        navigationService.goToHeaderMenuButtonsPage(ButtonsEnum.LOGOUT.getButton());
        LoginPage loginPage=new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isOpened(), "Login page isn't opened");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckFormForgetPasswordIsWork() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isOpened(), "Login page isn't opened");
        ForgetPasswordPage forgetPasswordPage = loginPage.clickForgetPasswordButton();
        Assert.assertTrue(forgetPasswordPage.isOpened(), "Page isn't opened");
        forgetPasswordPage.fillUsernameForm(R.TESTDATA.get("TEST_ADMIN"));
        PopUpForgetPassword popUpForgetPassword = forgetPasswordPage.clickResetBtn();
        Assert.assertTrue(popUpForgetPassword.isOpened(), "Pop up isn't present");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckFormForgetPasswordIsWorkNegative() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isOpened(), "Login page isn't opened");
        ForgetPasswordPage forgetPasswordPage = loginPage.clickForgetPasswordButton();
        Assert.assertTrue(forgetPasswordPage.isOpened(), "Page isn't opened");
        forgetPasswordPage.clickResetBtn();
        Assert.assertTrue(forgetPasswordPage.isErrorMessagePresent(), "Reset password is success");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckLoginHowUserNegative(){//
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isOpened(), "Login page isn't opened");
        loginPage.fillUsernameField("Masha");
        loginPage.fillPasswordField("Masha_123");
        PimPage pimPage = loginPage.clickLoginButton();
//        HamburgerMenu hamburgerMenu = pimPage.getHamburgerMenu();
//        Assert.assertTrue(hamburgerMenu.isAdminButtonPresent(),"User login isn't correct");
        Assert.assertTrue(loginPage.isAlertPresented(),"Login is success");
    }
}
