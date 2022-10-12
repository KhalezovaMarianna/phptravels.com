package testsPhptravels.pagesTests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.pages.*;

public class OrderPageTests extends AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(OrderPageTests.class);

    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckOrderReservationIsWorkNegative() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't open");
        homePage.typeCityHotelsField(R.TESTDATA.get("TEST_CITY_HOTEL"));
        SearchPage searchPage = homePage.clickSearchHotelsButton();
        Assert.assertTrue(searchPage.isOpened(), "Search page isn't open");
        ProductPage productPage = searchPage.clickHotelButtonByIndex();
        Assert.assertTrue(productPage.isOpened(), "Product page isn't open");
        OrderPage orderPage = productPage.clickBookNowButton();
        Assert.assertTrue(orderPage.isOpened(), "Order page isn't open");
        BookingInvoicePage bookingInvoicePage = orderPage.clickConfirmBookingButton();
        Assert.assertFalse(bookingInvoicePage.isOpened(), "Order is success");//Order page is opened
    }

    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckOrderReservationIsWork() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't open");
        homePage.typeCityHotelsField(R.TESTDATA.get("TEST_CITY_HOTEL"));
        SearchPage searchPage = homePage.clickSearchHotelsButton();
        Assert.assertTrue(searchPage.isOpened(), "Search page isn't open");
        ProductPage productPage = searchPage.clickHotelButtonByIndex();
        Assert.assertTrue(productPage.isOpened(), "Product page isn't open");
        OrderPage orderPage = productPage.clickBookNowButton();
        Assert.assertTrue(orderPage.isOpened(), "Order page is open");
        orderPage.fillFirstNameField(R.TESTDATA.get("TEST_FIRSTNAME"));
        orderPage.fillLastNameField(R.TESTDATA.get("TEST_LASTNAME"));
        orderPage.fillEmailField(R.TESTDATA.get("TEST_USER"));
        orderPage.fillPhoneField(R.TESTDATA.get("TEST_PHONE"));
        orderPage.fillAddressField(R.TESTDATA.get("TEST_ADDRESS"));
        BookingInvoicePage bookingInvoicePage = orderPage.clickConfirmBookingButton();
        Assert.assertTrue(bookingInvoicePage.isOpened(), "Booking Invoice page isn't open");
    }

    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckCheckUserDataIsCorrect() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't opened");
        homePage.clickSearchTabFlights();
        homePage.typeFlightFromField(R.TESTDATA.get("TEST_AIRPORT"));
        homePage.typeDestinationField(R.TESTDATA.get("TEST_DESTINATION"));
        SearchPage searchPage = homePage.clickFlightSearchButton();
        OrderPage orderPage = searchPage.clickFlightButtonByIndex();
        Assert.assertTrue(orderPage.isOpened(), "Order page isn't opened");
        orderPage.fillFirstNameField(R.TESTDATA.get("TEST_FIRSTNAME"));
        orderPage.fillLastNameField(R.TESTDATA.get("TEST_LASTNAME"));
        orderPage.fillEmailField(R.TESTDATA.get("TEST_USER"));
        orderPage.fillPhoneField(R.TESTDATA.get("TEST_PHONE"));
        orderPage.fillAddressField(R.TESTDATA.get("TEST_ADDRESS"));
        BookingInvoicePage bookingInvoicePage = orderPage.clickConfirmBookingButton();
        Assert.assertTrue(bookingInvoicePage.isOpened(), "Booking invoice page isn't opened");
        Assert.assertEquals(bookingInvoicePage.getUsersEmail(), R.TESTDATA.get("TEST_USER"), "Users data isn't correct");
    }

    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckFlightPriceDisplayedCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't opened");
        SearchPage searchPage = homePage.openTopFlightByIndex();
        if (searchPage.isEmptySearch()) {
            LOGGER.info("Test isn't correct");
        } else {
            String totalCount = searchPage.getTotalCount();
            System.out.println(totalCount);
            OrderPage orderPage = searchPage.clickFlightButtonByIndex();
            System.out.println(orderPage.getTotalPrice());
            Assert.assertTrue(orderPage.isOpened(), "Order page isn't opened");
            Assert.assertEquals(orderPage.getTotalPrice(), totalCount, "Total count isn't correct");
        }
    }
}
