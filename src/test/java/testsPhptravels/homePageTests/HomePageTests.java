package testsPhptravels.homePageTests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.pages.HomePage;
import web.pages.SearchPage;
import web.utils.enums.HomeButtonsEnum;

public class HomePageTests extends AbstractTest {
    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckHomePageButtonsIsWorkCorrectly(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(),"Home page isn't open");
        homePage.clickHomeButtons(HomeButtonsEnum.VISA.getButton());
        Assert.assertTrue(homePage.checkWorkingOfHomeButtons(HomeButtonsEnum.VISA.getCheckButton()),"Visa button isn't work");
        homePage.clickHomeButtons(HomeButtonsEnum.HOTELS.getButton());
        Assert.assertTrue(homePage.checkWorkingOfHomeButtons(HomeButtonsEnum.HOTELS.getCheckButton()),"Hotels button isn't work");
        homePage.clickHomeButtons(HomeButtonsEnum.FLIGHTS.getButton());
        Assert.assertFalse(homePage.checkWorkingOfHomeButtons(HomeButtonsEnum.FLIGHTS.getCheckButton()),"Flights button isn't work");
        homePage.clickHomeButtons(HomeButtonsEnum.TOURS.getButton());
        Assert.assertTrue(homePage.checkWorkingOfHomeButtons(HomeButtonsEnum.TOURS.getCheckButton()),"Tours button isn't work");
        homePage.clickHomeButtons(HomeButtonsEnum.TRANSFERS.getButton());
        Assert.assertTrue(homePage.checkWorkingOfHomeButtons(HomeButtonsEnum.TRANSFERS.getCheckButton()),"Transfers button isn't work");
    }

    @Test
    @MethodOwner(owner = "marianna")
    public void testSearchForFlightWithDefaultDate(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(),"Home page isn't open");
        homePage.clickHomeButtons(HomeButtonsEnum.FLIGHTS.getButton());
        homePage.typeFlightFromForm(R.TESTDATA.get("TEST_AIRPORT"));
        homePage.typeDestinationForm(R.TESTDATA.get("TEST_DESTINATION"));
        SearchPage searchPage = homePage.clickFlightSearchButton();
        Assert.assertTrue(searchPage.isEmptySearch());
    }
}
