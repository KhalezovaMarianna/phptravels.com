package web.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.Footer;
import web.components.Header;
import web.utils.enums.HomeButtonsEnum;

public class HomePage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//*[@id=\"fadein\"]/header/div")
    private Header header;

    @FindBy(xpath = "//*[@id=\"fadein\"]/section[11]")
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
    private ExtendedWebElement searchHotelsBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public SearchPage clickSearchHotelsBtn(){
        searchHotelsBtn.click();
        return new SearchPage(getDriver());
    }



    public String getRecentHotel(){
        return recentHotel.getText();
    }

    public void typeCityHotelsField(String city){
        citiesHotelsField.click();
        cityField.type(city);
    }



    public boolean checkRecentSearchesIsPresent(){return recentSearchesTitle.isElementPresent();}

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

    public void clickSearchTabVisa() {
        homeBtn.format("visa").click();
    }

    public void clickSearchTabHotels() {
        homeBtn.format("hotels").click();
    }

    public boolean checkIsFlightsFormPresent() {
        if (checkingHomeBtn.format("flights").isElementPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIsHotelsFormPresent() {
        if (checkingHomeBtn.format("hotels-search").isElementPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIsToursFormPresent() {
        if (checkingHomeBtn.format("tours-search").isElementPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIsVisaFormPresent() {
        if (checkingHomeBtn.format("visa-submit").isElementPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkTopFlightsArePresent(){
        return topFlights.isElementPresent();
    }

    public boolean checkFeaturedHotelsArePresent(){
        return featuredHotels.isElementPresent();
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}
