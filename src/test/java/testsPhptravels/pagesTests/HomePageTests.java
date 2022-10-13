package testsPhptravels.pagesTests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import webPhptravel.components.Header;
import webPhptravel.pages.HomePage;
import webPhptravel.pages.SearchPage;

public class HomePageTests extends AbstractTest {
    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckHomePageButtonsIsWorkCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't open");
        homePage.clickSearchTabVisa();
        Assert.assertTrue(homePage.isVisaFormPresent(), "Visa button isn't work");
        homePage.clickSearchTabHotels();
        Assert.assertTrue(homePage.isHotelsFormPresent(), "Hotels button isn't work");
        homePage.clickSearchTabFlights();
        Assert.assertFalse(homePage.isFlightsFormPresent(), "Flights button isn't work");
        homePage.clickSearchTabTours();
        Assert.assertTrue(homePage.isToursFormPresent(), "Tours button isn't work");
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
        Assert.assertTrue(homePage.isTopFlightsTitlePresent(), "Top flights aren't present");
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
        Assert.assertEquals(homePage.getRecentHotel(), R.TESTDATA.get("TEST_CITY_HOTEL"), "Hotels isn't present");
    }
}


