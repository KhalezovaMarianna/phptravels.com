package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.pages.*;
import webOrangehrmlive.pages.headerPages.ChangePasswordPage;
import webOrangehrmlive.pages.headerPages.PopUpAboutPage;
import webOrangehrmlive.utils.enums.ButtonsEnum;

public class ComponentsTests extends BaseTest {

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckHamburgerMenuButtonIsWork() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.ADMIN);
        AdminPage adminPage = new AdminPage(getDriver());
//        Assert.assertTrue(adminPage.isOpened(), "Admin page isn't opened");
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.DIRECTORY);
        DirectoryPage directoryPage = new DirectoryPage(getDriver());
        Assert.assertTrue(directoryPage.isOpened(),"Directory page isn't opened");
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.LEAVE);
        LeavePage leavePage = new LeavePage(getDriver());
        Assert.assertTrue(leavePage.isOpened(),"Leave page isn't opened");
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.MY_INFO);
        MyInfoPage myInfoPage = new MyInfoPage(getDriver());
        Assert.assertTrue(myInfoPage.isOpened(),"My info page isn't opened");
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.PERFOMANCE);
        PerfomancePage perfomancePage = new PerfomancePage(getDriver());
        Assert.assertTrue(perfomancePage.isOpened(),"Perfomance page isn't opened");
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.MAINTENANCE);
        MaintenancePage maintenancePage = new MaintenancePage(getDriver());
        Assert.assertTrue(maintenancePage.isOpened(),"Maintence page isn't opened");
        maintenancePage.clickCancelButton();
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.TIME);
        TimePage timePage = new TimePage(getDriver());
        Assert.assertTrue(timePage.isOpened(),"Time page isn't opened");
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.PIM);
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.RECRUITMENT);
        RecruitmentPage recruitmentPage = new RecruitmentPage(getDriver());
        Assert.assertTrue(recruitmentPage.isOpened(),"Recruitment page isn't opened");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckHeaderButtonsAreWork(){
        authorisationService.login();
        navigationService.goToHeaderMenuButtonsPage(ButtonsEnum.CHANGE_PASSWORD.getButton());
        ChangePasswordPage changePasswordPage =new ChangePasswordPage(getDriver());
        Assert.assertTrue(changePasswordPage.isOpened(),"Change password page isn't opened");
        navigationService.goToHeaderMenuButtonsPage(ButtonsEnum.ABOUT.getButton());
        PopUpAboutPage popUpAboutPage = new PopUpAboutPage(getDriver());
        Assert.assertTrue(popUpAboutPage.isOpened(),"About page isn't opened");
        popUpAboutPage.clickCloseButton();
        navigationService.goToHeaderMenuButtonsPage(ButtonsEnum.LOGOUT.getButton());
        LoginPage loginPage= new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isOpened(),"Login page isn't opened");
    }
}
