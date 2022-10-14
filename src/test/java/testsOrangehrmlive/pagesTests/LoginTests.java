package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.components.HeaderMenu;
import webOrangehrmlive.pages.LoginPage;
import webOrangehrmlive.pages.PimPage;


public class LoginTests extends BaseTest {

    @Test
    @MethodOwner(owner = "Marianna")
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isOpened(),"Login page isn't opened");
        loginPage.fillUsernameField("Admin");
        loginPage.fillPasswordField("admin123");
        PimPage pimPage = loginPage.clickLoginButton();
        Assert.assertTrue(pimPage.isOpened(),"PIM page isn't opened");
    }

    @Test
    @MethodOwner(owner = "Maarianna")
    public void testLogout(){
        PimPage pimPage = authorisationService.login();
        HeaderMenu headerMenu=pimPage.getHeaderMenu();
        headerMenu.clickProfileLabelButton();
        LoginPage loginPage=headerMenu.clickLogoutButton();
        Assert.assertTrue(loginPage.isOpened(),"Login page isn't opened");
    }
}
