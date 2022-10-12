package testsPhptravels.pagesTests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.components.Header;
import web.pages.HomePage;
import web.pages.SearchPage;

public class HomePageTests extends AbstractTest {
    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckHomePageButtonsIsWorkCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't open");
        homePage.clickSearchTabVisa();
        Assert.assertTrue(homePage.checkIsVisaFormPresent(), "Visa button isn't work");
        homePage.clickSearchTabHotels();
        Assert.assertTrue(homePage.checkIsHotelsFormPresent(), "Hotels button isn't work");
        homePage.clickSearchTabFlights();
        Assert.assertFalse(homePage.checkIsFlightsFormPresent(), "Flights button isn't work");
        homePage.clickSearchTabTours();
        Assert.assertTrue(homePage.checkIsToursFormPresent(), "Tours button isn't work");
    }

    @Test
    @MethodOwner(owner = "marianna")
    public void testSearchForFlightWithDefaultDate() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't open");
        homePage.clickFlightSearchButton();
        homePage.typeFlightFromField(R.TESTDATA.get("TEST_AIRPORT"));
        homePage.typeDestinationField(R.TESTDATA.get("TEST_DESTINATION"));
        SearchPage searchPage = homePage.clickFlightSearchButton();
        Assert.assertTrue(searchPage.isEmptySearch(), "Search page is empty and opened");
    }

    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckAllFormsOnPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't open");
        Assert.assertTrue(homePage.checkTopFlightsTitleIsPresent(), "Top flights aren't present");
        Assert.assertTrue(homePage.checkFeaturedHotelsArePresent(), "Featured hotels aren't present");
    }

    @Test
    @MethodOwner(owner = "marianna")
    public void testRecentSearchesArePresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't open");
        homePage.typeCityHotelsField(R.TESTDATA.get("TEST_CITY_HOTEL"));
        SearchPage searchPage = homePage.clickSearchHotelsButton();
        Header header = searchPage.getHeader();
        Assert.assertTrue(searchPage.isOpened(), "Search page is open");
        header.clickTitle();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't open");
//        Assert.assertTrue(homePage.checkRecentSearchesIsPresent(),"Recent searches isn't present");
        Assert.assertEquals(homePage.getRecentHotel(), R.TESTDATA.get("TEST_CITY_HOTEL"), "Hotels isn't present");
    }


}