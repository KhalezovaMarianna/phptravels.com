package webPhptravel.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webPhptravel.components.Footer;
import webPhptravel.components.Header;

import java.security.SecureRandom;

public class HomePage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//*[@id=\"fadein\"]/header/div")
    private Header header;

    @FindBy(xpath = "//*[@id=\"fadein\"]/section[4]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"Tab\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//form[contains(@id,\"%s\")]")
    private ExtendedWebElement checkingHomeBtn;

    @FindBy(xpath = "//button[contains(@aria-controls, \"%s\")]")
    private ExtendedWebElement homeBtn;

    @FindBy(xpath = "//input[@name=\"from\"]")
    private ExtendedWebElement flightFromField;

    @FindBy(xpath = "//input[@placeholder =\"To Destination\"]")
    private ExtendedWebElement destinationForm;

    @FindBy(xpath = "//button[@id =\"flights-search\"]")
    private ExtendedWebElement flightSearchBtn;

    @FindBy(xpath = "//div[@role=\"tabpanel\"]")
    private ExtendedWebElement topFlights;

    @FindBy(xpath = "//div[@class='container-fluid']")
    private ExtendedWebElement featuredHotels;

    @FindBy(xpath = "//p[@class=\"mb-4 mt-2\"]")
    private ExtendedWebElement recentSearchesTitle;

    @FindBy(xpath = "//span[@id=\"select2-hotels_city-container\"]")
    private ExtendedWebElement citiesHotelsField;

    @FindBy(xpath = "//input[@aria-controls=\"select2-hotels_city-results\"]")
    private ExtendedWebElement cityField;

    @FindBy(xpath = "//p[@class=\"msg-text px-2\"]")
    private ExtendedWebElement recentHotel;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "(//input[@id=\"departure\"])[1]")
    private ExtendedWebElement dataFlights;

    @FindBy(xpath = "//p/span[@class=\"%s\"]")
    private ExtendedWebElement numberOfTravellers;

    @FindBy(xpath = "//input[contains(@id, \"%s\")]")
    private ExtendedWebElement dataHotels;

    @FindBy(xpath = "(//span[@aria-labelledby=\"select2-from_country-container\"])[1]")
    private ExtendedWebElement fromVisaField;

    @FindBy(xpath = "(//span[@aria-labelledby=\"select2-to_country-container\"])[1]")
    private ExtendedWebElement toVisaField;

    @FindBy(xpath = "(//h3[@class=\"deal__title\"])[%s]")
    private ExtendedWebElement randomElementTopFlights;

    @FindBy(xpath = "//li[text()=\"Belarus\"]")//abstract
    private ExtendedWebElement belarusLabel;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public SearchPage clickSearchHotelsButton() {
        searchBtn.clickByJs();
        return new SearchPage(getDriver());
    }

    public SubmissionFormPage clickSearchVisaButton() {
        searchBtn.click();
        return new SubmissionFormPage(getDriver());
    }

    public SearchPage openTopFlightByIndex() {
        var random = new SecureRandom();
        int randomIndex = random.nextInt(10);
        randomElementTopFlights.format(randomIndex).click();
        return new SearchPage(getDriver());
    }

    public void fillFromVisaField(String fromCountry) {
        fromVisaField.clickByJs();
        fromVisaField.type(fromCountry);
//        belarusLabel.click();
        belarusLabel.clickByJs();
    }

    public void fillToVisaField(String toCountry) {
        toVisaField.click();
        toVisaField.type(toCountry);
    }

    public String getRecentHotel() {
        return recentHotel.getText();
    }

    public void typeCityHotelsField(String city) {
        citiesHotelsField.click();
        cityField.type(city);
    }

    public boolean checkRecentSearchesIsPresent() {
        return recentSearchesTitle.isElementPresent();
    }

    public void typeFlightFromField(String city) {
        flightFromField.type(city);
    }

    public void typeDestinationField(String city) {
        destinationForm.type(city);
    }

    public SearchPage clickFlightSearchButton() {
        flightSearchBtn.click();
        return new SearchPage(getDriver());
    }

    public void clickSearchTabFlights() {
        homeBtn.format("flights").click();
    }

    public void clickSearchTabTours() {
        homeBtn.format("tours").click();
    }

    public void clickSearchTabVisa() {//work around
        homeBtn.format("flights").click();
        homeBtn.format("hotels").click();
        homeBtn.format("visa").click();

    }

    public void clickSearchTabHotels() {
        homeBtn.format("hotels").click();
        homeBtn.format("flights").click();
        homeBtn.format("hotels").click();
    }

    public boolean isFlightsFormPresent() {
        return checkingHomeBtn.format("flights").isElementPresent();
    }

    public boolean isHotelsFormPresent() {
        return checkingHomeBtn.format("hotels-search").isElementPresent();

    }

    public boolean isToursFormPresent() {
        return checkingHomeBtn.format("tours-search").isElementPresent();

    }

    public boolean isVisaFormPresent() {
        return (checkingHomeBtn.format("visa-submit").isElementPresent());
    }

    public boolean isTopFlightsTitlePresent() {//isTopFlightsItemsPresent TODO:
        return topFlights.isElementPresent();
    }

    public boolean checkFeaturedHotelsArePresent() {
        return featuredHotels.isElementPresent();
    }


    public String getFlightsData() {
        return dataFlights.getAttribute("value");
    }

    public String getFlightsTravellers() {
        return numberOfTravellers.format("guest_flights").getText();
    }

    public String getHotelsTravellers() {
        return numberOfTravellers.format("guest_hotels").getText();
    }

    public String getCheckinDateHotels() {
        return dataHotels.format("checkin").getAttribute("value");
    }

    public String getCheckoutDateHotels() {
        return dataHotels.format("checkout").getAttribute("value");
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}

