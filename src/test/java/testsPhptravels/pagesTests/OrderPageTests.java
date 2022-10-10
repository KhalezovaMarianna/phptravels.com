package testsPhptravels.pagesTests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.pages.*;

public class OrderPageTests extends AbstractTest {
    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckOrderReservationIsWorkNegative() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't open");
        homePage.typeCityHotelsField(R.TESTDATA.get("TEST_CITY_HOTEL"));
        SearchPage searchPage = homePage.clickSearchHotelsBtn();
        Assert.assertTrue(searchPage.isOpened(),"Search page isn't open");
        ProductPage productPage =searchPage.clickFirstHotelBtn();
        Assert.assertTrue(productPage.isOpened(),"Product page isn't open");
        OrderPage orderPage =productPage.clickBookNow();
        Assert.assertTrue(orderPage.isOpened(),"Order page isn't open");
        BookingInvoicePage bookingInvoicePage = orderPage.clickConfirmBookingButton();
        Assert.assertFalse(bookingInvoicePage.isOpened(),"Order is success");
    }

    @Test
    @MethodOwner(owner = "marianna")
    public void testCheckOrderReservationIsWork() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't open");
        homePage.typeCityHotelsField(R.TESTDATA.get("TEST_CITY_HOTEL"));
        SearchPage searchPage = homePage.clickSearchHotelsBtn();
        Assert.assertTrue(searchPage.isOpened(),"Search page isn't open");
        ProductPage productPage =searchPage.clickFirstHotelBtn();
        Assert.assertTrue(productPage.isOpened(),"Product page isn't open");
        OrderPage orderPage =productPage.clickBookNow();
        Assert.assertTrue(orderPage.isOpened(),"Order page is open");
        orderPage.fillFirstNameField(R.TESTDATA.get("TEST_FIRSTNAME"));
        orderPage.fillLastNameField(R.TESTDATA.get("TEST_LASTNAME"));
        orderPage.fillEmailField(R.TESTDATA.get("TEST_USER"));
        orderPage.fillPhoneField(R.TESTDATA.get("TEST_PHONE"));
        orderPage.fillAddressField(R.TESTDATA.get("TEST_ADDRESS"));
        BookingInvoicePage bookingInvoicePage =orderPage.clickConfirmBookingButton();
        Assert.assertTrue(bookingInvoicePage.isOpened(),"Booking Invoice page isn't open");
    }
}
