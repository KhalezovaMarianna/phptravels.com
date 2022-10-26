package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.components.HeaderMenu;
import webOrangehrmlive.pages.MyInfoPage;
import webOrangehrmlive.utils.enums.ButtonsEnum;

public class MyInfoTests extends BaseTest {
    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckProfileNameIsCorrect() {
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(ButtonsEnum.MY_INFO);
        MyInfoPage myInfoPage = new MyInfoPage(getDriver());
        HeaderMenu headerMenu = myInfoPage.getHeaderMenu();
        Assert.assertTrue(myInfoPage.isOpened(), "My info page isn't opened");
        Assert.assertEquals(myInfoPage.getFirstName(), headerMenu.getFirstName(), "Name isn't correct");
        Assert.assertEquals(myInfoPage.getLastName(), headerMenu.getLastName(), "Last name isn't correct");
    }
}
