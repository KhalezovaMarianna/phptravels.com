package testsOrangehrmlive.pagesTests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import testsOrangehrmlive.base.BaseTest;
import webOrangehrmlive.pages.MaintenancePage;
import webOrangehrmlive.utils.enums.HamburgerButtonsEnum;

public class MaintenancePageTests extends BaseTest {

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckMaintenancePageIsWork(){
        authorisationService.login();
        navigationService.goToHamburgerButtonsPage(HamburgerButtonsEnum.MAINTENANCE);
        MaintenancePage maintenancePage =new MaintenancePage(getDriver());
        maintenancePage.fillPasswordForm("admin123");
        maintenancePage.clickConfirmButton();
        Assert.assertTrue(maintenancePage.mainPageIsOpened(),"Maintenance isn't worked");
    }
}
