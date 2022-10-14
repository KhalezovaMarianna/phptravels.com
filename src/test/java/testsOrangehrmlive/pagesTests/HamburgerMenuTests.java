package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.components.HamburgerMenu;
import webOrangehrmlive.components.HeaderMenu;
import webOrangehrmlive.pages.*;
import webOrangehrmlive.utils.HamburgerButtonsEnum;

public class HamburgerMenuTests extends BaseTest {

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckHamburgerMenuButtonIsWork() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isOpened());
        loginPage.fillUsernameField();
        loginPage.fillPasswordField();
        PimPage pimPage = loginPage.clickLoginButton();
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
}
