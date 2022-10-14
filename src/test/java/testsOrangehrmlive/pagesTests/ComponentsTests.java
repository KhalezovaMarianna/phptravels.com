package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.components.HamburgerMenu;
import webOrangehrmlive.components.HeaderMenu;
import webOrangehrmlive.pages.*;
import webOrangehrmlive.pages.headerPages.ChangePasswordPage;
import webOrangehrmlive.pages.headerPages.PopUpAboutPage;
import webOrangehrmlive.utils.enums.HamburgerButtonsEnum;

public class ComponentsTests extends BaseTest {

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckHamburgerMenuButtonIsWork() {
        PimPage pimPage = authorisationService.login();
        HeaderMenu headerMenu = pimPage.getHeaderMenu();
        headerMenu.openHamburgerMenu();
        HamburgerMenu hamburgerMenu = pimPage.getHamburgerMenu();
        hamburgerMenu.openDifferencePages(HamburgerButtonsEnum.ADMIN.getButton());
        AdminPage adminPage = new AdminPage(getDriver());
        Assert.assertTrue(adminPage.isOpened(), "Admin page isn't opened");
        hamburgerMenu.openDifferencePages(HamburgerButtonsEnum.DIRECTORY.getButton());
        DirectoryPage directoryPage = new DirectoryPage(getDriver());
        Assert.assertTrue(directoryPage.isOpened(),"Directory page isn't opened");
//        headerMenu.openHamburgerMenu();
        hamburgerMenu.openDifferencePages(HamburgerButtonsEnum.LEAVE.getButton());
        LeavePage leavePage = new LeavePage(getDriver());
        Assert.assertTrue(leavePage.isOpened(),"Leave page isn't opened");
        hamburgerMenu.openDifferencePages(HamburgerButtonsEnum.MY_INFO.getButton());
        MyInfoPage myInfoPage = new MyInfoPage(getDriver());
        Assert.assertTrue(myInfoPage.isOpened(),"My info page isn't opened");
        headerMenu.openHamburgerMenu();
        hamburgerMenu.openDifferencePages(HamburgerButtonsEnum.PERFOMANCE.getButton());
        PerfomancePage perfomancePage = new PerfomancePage(getDriver());
        Assert.assertTrue(perfomancePage.isOpened(),"Perfomance page isn't opened");
        headerMenu.openHamburgerMenu();
        hamburgerMenu.openDifferencePages(HamburgerButtonsEnum.MAINTENANCE.getButton());
        MaintenancePage maintenancePage = new MaintenancePage(getDriver());
        Assert.assertTrue(maintenancePage.isOpened(),"Maintence page isn't opened");
        maintenancePage.clickCancelButton();
        headerMenu.openHamburgerMenu();
        hamburgerMenu.openDifferencePages(HamburgerButtonsEnum.TIME.getButton());
        TimePage timePage = new TimePage(getDriver());
        Assert.assertTrue(timePage.isOpened(),"Time page isn't opened");
        headerMenu.openHamburgerMenu();
        hamburgerMenu.openDifferencePages(HamburgerButtonsEnum.PIM.getButton());
        Assert.assertTrue(pimPage.isOpened(),"PIM page isn't opened");
        headerMenu.openHamburgerMenu();
        hamburgerMenu.openDifferencePages(HamburgerButtonsEnum.RECRUITMENT.getButton());
        RecruitmentPage recruitmentPage = new RecruitmentPage(getDriver());
        Assert.assertTrue(recruitmentPage.isOpened(),"Recruitment page isn't opened");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckHeaderButtonsAreWork(){
        PimPage pimPage = authorisationService.login();
        HeaderMenu headerMenu = pimPage.getHeaderMenu();
        headerMenu.clickProfileLabelButton();
        ChangePasswordPage changePasswordPage=headerMenu.clickChangePasswordButton();
        Assert.assertTrue(changePasswordPage.isOpened(),"Change password page isn't opened");
        headerMenu.clickProfileLabelButton();
        PopUpAboutPage popUpAboutPage = headerMenu.clickAboutButton();
        Assert.assertTrue(popUpAboutPage.isOpened(),"About page isn't opened");
        popUpAboutPage.clickCloseButton();
        headerMenu.clickProfileLabelButton();
        LoginPage loginPage = headerMenu.clickLogoutButton();
        Assert.assertTrue(loginPage.isOpened(),"Login page isn't opened");
    }
}
