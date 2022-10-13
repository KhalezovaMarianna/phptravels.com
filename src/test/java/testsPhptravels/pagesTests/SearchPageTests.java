package testsPhptravels.pagesTests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import webPhptravel.pages.*;

public class SearchPageTests extends AbstractTest {

    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckFlightsDateAndPassengersAreDisplayedCorrect() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't opened");
        homePage.clickSearchTabFlights();
        homePage.typeFlightFromField(R.TESTDATA.get("TEST_AIRPORT"));
        homePage.typeDestinationField(R.TESTDATA.get("TEST_DESTINATION"));
        String travellers = homePage.getFlightsTravellers();
        SearchPage searchPage = homePage.clickFlightSearchButton();
        Assert.assertEquals(searchPage.getData(), homePage.getFlightsData(), "Data isn't correct");
        Assert.assertEquals(travellers, searchPage.getTravellers(), "Number of travellers isn't correct");
    }


    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckHotelsDateAndPassengersAreDisplayedCorrect() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't opened");
        homePage.clickSearchTabHotels();
        homePage.typeCityHotelsField(R.TESTDATA.get("TEST_CITY_HOTEL"));
        String travellers = homePage.getHotelsTravellers();
        String dataCheckIn = homePage.getCheckinDateHotels();
        String dataCheckOut = homePage.getCheckoutDateHotels();
        SearchPage searchPage = homePage.clickSearchHotelsButton();
        Assert.assertEquals(searchPage.getTravellers(), travellers, "Count of travellers isn't correct");
        Assert.assertEquals(searchPage.getCheckinData(), dataCheckIn, "Checkin date isn't correct");
        Assert.assertEquals(searchPage.getCheckoutData(), dataCheckOut, "Checkout data isn't correct");
    }

    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckVisaDateAndPassengersAreDisplayedCorrect() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't opened");
        homePage.clickSearchTabHotels();
        homePage.typeCityHotelsField(R.TESTDATA.get("TEST_CITY_HOTEL"));
        String travellers = homePage.getHotelsTravellers();
        String dataCheckIn = homePage.getCheckinDateHotels();
        String dataCheckOut = homePage.getCheckoutDateHotels();
        SearchPage searchPage = homePage.clickSearchHotelsButton();
        Assert.assertEquals(searchPage.getTravellers(), travellers, "Count of travellers isn't correct");
        Assert.assertEquals(searchPage.getCheckinData(), dataCheckIn, "Checkin date isn't correct");
        Assert.assertEquals(searchPage.getCheckoutData(), dataCheckOut, "Checkout data isn't correct");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    public void testCheckVisaRegistrationIsNotWorkCorrect() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't opened");
        homePage.clickSearchTabVisa();
        homePage.fillFromVisaField(R.TESTDATA.get("TEST_FROM_COUNTRY"));
        homePage.fillToVisaField(R.TESTDATA.get("TEST_TO_COUNTRY"));
        SubmissionFormPage submissionFormPage = homePage.clickSearchVisaButton();
        Assert.assertTrue(submissionFormPage.isOpened(), "Submission form isn't opened");
        submissionFormPage.clickSubmitButton();
        Assert.assertEquals(submissionFormPage.getSuccessSubmitText(), "Your visa form has been submitted", "Submit isn't success");
    }
}
