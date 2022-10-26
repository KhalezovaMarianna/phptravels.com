package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.components.DeleteButton;
import webOrangehrmlive.components.EditButton;
import webOrangehrmlive.components.HeaderMenu;
import webOrangehrmlive.pages.AdminPage;
import webOrangehrmlive.pages.adminPages.AddUserPage;
import webOrangehrmlive.pages.adminPages.CorporateBrandingPage;
import webOrangehrmlive.pages.adminPages.EditPage;
import webOrangehrmlive.pages.adminPages.PopUpDeletePage;
import webOrangehrmlive.utils.enums.ButtonsEnum;

public class AdminTests extends BaseTest {

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckChooseAdminIsWork() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.ADMIN);
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
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.ADMIN);
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
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.ADMIN);
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
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        AddUserPage addUserPage = adminPage.clickAddButton();
        addUserPage.clickSaveButton();
        Assert.assertTrue(addUserPage.checkSaveIsNotSuccess(), "Add User isn't worked");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckAddUserIsWorkNegative() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        AddUserPage addUserPage = adminPage.clickAddButton();
        Assert.assertTrue(addUserPage.isOpened(), "Add user page isn't opened");
        addUserPage.fillEmployeeForm("Cecil  Bonaparte");
        addUserPage.fillStatusForm();
        addUserPage.fillUsernameForm("Dasha");
        addUserPage.fillPasswordForm("Dasha_123");
        addUserPage.fillConfirmPasswordForm("Dasha_123");
        addUserPage.fillUserRoleForm();
        addUserPage.clickSaveButton();
        Assert.assertFalse(adminPage.isOpened(), "Add user isn't correct");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void TestCheckChangeColor() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        CorporateBrandingPage corporateBrandingPage = adminPage.clickCorporateBranding();
        HeaderMenu headerMenu = corporateBrandingPage.getHeaderMenu();
        int firstCount = headerMenu.getPixels();
        corporateBrandingPage.changeColorOne(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
        corporateBrandingPage.changeColorTwo(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
        Assert.assertEquals(headerMenu.getPixels(), firstCount, "Color isn't change");

    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckDownloadingImage() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        CorporateBrandingPage corporateBrandingPage = adminPage.clickCorporateBranding();
        corporateBrandingPage.downloadFile();
        corporateBrandingPage.clickSaveButton();
        Assert.assertTrue(corporateBrandingPage.checkDownloadingImage(), "Downloading isn't success");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckChangeUser() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        Assert.assertTrue(adminPage.isOpened(), "Admin page isn't opened");
        adminPage.fillUsernameField("Alice.Duval");
        adminPage.clickSearchButton();
        Assert.assertEquals(adminPage.getSearchCount(), "1", "Search isn't correct");
        Assert.assertEquals(adminPage.getUsername(), "Alice.Duval", "User isn't correct");
        EditButton editButton = adminPage.getEditButton();
        editButton.clickEditButton();
        EditPage editPage = new EditPage(getDriver());
        Assert.assertTrue(editPage.isOpened(), "Edit page isn't opened");
        editPage.fillUsernameForm("MashaHal");
        editPage.clickSaveButton();
        Assert.assertTrue(adminPage.isOpened(), "Admin page isn't opened");
        adminPage.fillUsernameField("MashaHal");
        adminPage.clickSearchButton();
        Assert.assertEquals(adminPage.getSearchCount(), "1", "Search isn't correct");
        Assert.assertEquals(adminPage.getUsername(), "MashaHal", "User isn't correct");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testDeleteUserByName() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
        adminPage.fillUsernameField("Aaliyah.Haq");
        adminPage.clickSearchButton();
        Assert.assertEquals(adminPage.getSearchCount(), "1", "Search isn't correct");
        Assert.assertEquals(adminPage.getUsername(), "Aaliyah.Haq", "User isn't correct");
        DeleteButton deleteButton = adminPage.getDeleteButton();
        deleteButton.clickDeleteButton();
        PopUpDeletePage popUpDeletePage = new PopUpDeletePage(getDriver());
        Assert.assertTrue(popUpDeletePage.isOpened(), "Pop up isn't opened");
        popUpDeletePage.clickDeleteButton();
        Assert.assertTrue(adminPage.checkFoundIsNotSuccess(), "User isn't deleted");
    }
}
