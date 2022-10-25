package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.components.DeleteButton;
import webOrangehrmlive.components.HamburgerMenu;
import webOrangehrmlive.components.HeaderMenu;
import webOrangehrmlive.pages.AdminPage;
import webOrangehrmlive.pages.PimPage;
import webOrangehrmlive.pages.adminPages.AddUserPage;
import webOrangehrmlive.pages.adminPages.CorporateBrandingPage;
import webOrangehrmlive.utils.enums.HamburgerButtonsEnum;

public class AdminTests extends BaseTest {

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckChooseAdminIsWork() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(HamburgerButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        Assert.assertTrue(adminPage.isOpened(), "Admin page isn't opened");
        adminPage.fillUsernameField("Admin");
        adminPage.clickSearchButton();
        Assert.assertEquals(adminPage.getSearchCount(), "1", "Search isn't correct");
        Assert.assertEquals(adminPage.getSearchUsername(), "Admin", "Admin isn't correct");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckDeleteButtonIsWorkNegative() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(HamburgerButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        adminPage.fillUsernameField("Admin");
        adminPage.clickSearchButton();
        Assert.assertEquals(adminPage.getSearchCount(), "1", "Search isn't correct");
        DeleteButton deleteButton = adminPage.getDeleteButton();
        deleteButton.clickDeleteButton();
        Assert.assertEquals(adminPage.getSearchCount(), "1", "Search isn't correct");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckResetButtonIsWork() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(HamburgerButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        adminPage.fillUsernameField("Admin");
        adminPage.clickSearchButton();
        Assert.assertEquals(adminPage.getSearchCount(), "1", "Search isn't correct");
        adminPage.clickResetButton();
        Assert.assertNotEquals(adminPage.getSearchCount(), "1", "Reset button isn't work");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckAddUserWithoutDataNegative() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(HamburgerButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        AddUserPage addUserPage = adminPage.clickAddButton();
        addUserPage.clickSaveButton();
        Assert.assertTrue(addUserPage.checkSaveIsNotSuccess(), "Add User isn't worked");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckAddUserIsWork() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(HamburgerButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        AddUserPage addUserPage = adminPage.clickAddButton();
        Assert.assertTrue(addUserPage.isOpened(), "Add user page isn't opened");
        addUserPage.fillEmployeeForm("Peter Mac Anderson");
        addUserPage.fillStatusForm();
        addUserPage.fillUsernameForm("Masha");
        addUserPage.fillPasswordForm("Masha_123");
        addUserPage.fillConfirmPasswordForm("Masha_123");
        addUserPage.fillUserRoleForm();
        addUserPage.clickSaveButton();
        Assert.assertTrue(adminPage.isOpened(), "Add user isn't correct");
    }





    @Test
    @MethodOwner(owner = "Marianna")
    public void TestCheckChangeColor() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(HamburgerButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        CorporateBrandingPage corporateBrandingPage = adminPage.clickCorporateBranding();
        HeaderMenu headerMenu = corporateBrandingPage.getHeaderMenu();
        int firstCount = headerMenu.getPixels();
        corporateBrandingPage.changeColorOne(R.TESTDATA.get("TEST_COLOR"));
        corporateBrandingPage.changeColorTwo(R.TESTDATA.get("TEST_COLOR"));
        Assert.assertNotEquals(headerMenu.getPixels(),firstCount,"Color isn't change");

    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckDownloadingImage(){
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(HamburgerButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        CorporateBrandingPage corporateBrandingPage = adminPage.clickCorporateBranding();
        corporateBrandingPage.downloadFile();
        corporateBrandingPage.clickSaveButton();
        Assert.assertTrue(corporateBrandingPage.checkDownloadingImage(),"Downloading isn't success");
    }
}
