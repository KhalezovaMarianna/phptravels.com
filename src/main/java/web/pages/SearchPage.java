package web.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.Footer;
import web.components.Header;

public class SearchPage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//img[@alt=\"no results\"]")
    private ExtendedWebElement titleOfEmptySearch;

    @FindBy(xpath = "//a[@onclick=\"history.back()\"]")
    private ExtendedWebElement backToSearchBtn;

    @FindBy(xpath = "//*[@id=\"fadein\"]/header/div")
    private Header header;

    @FindBy(xpath = "//*[@id=\"fadein\"]/section[11]")
    private Footer footer;

    @FindBy(xpath = "//div/p/strong[contains(text(),\"Dates\")]/parent::p")
    private ExtendedWebElement dataFlights;

    @FindBy(xpath = "//div/p/strong[contains(text(),\"Adults\")]/parent::p")
    private ExtendedWebElement travellers;

    @FindBy(xpath = "(//span[@class=\"ladda-label\"])[%s]")
    private ExtendedWebElement indexHotel;

    @FindBy(xpath = "(//span[@class=\"btn btn-primary\"])[%s]")
    private ExtendedWebElement flightBurtonByIndex;

    @FindBy(xpath = "//div[@class=\"card-header\"]")
    private ExtendedWebElement searchFilterTitle;

    @FindBy(xpath = "//div/p/strong[contains(text(),\"1 Nights \")]/parent::p")
    private ExtendedWebElement dataHotels;

    @FindBy(xpath = "(//button/strong)[%s]")
    private ExtendedWebElement totalCount;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return searchFilterTitle.isElementPresent();
    }

    public boolean isEmptySearch() {
        return titleOfEmptySearch.isElementPresent();
    }

    public HomePage clickBackToSearchButton(){
        backToSearchBtn.click();
        return new HomePage(getDriver());
    }

    public ProductPage clickHotelButtonByIndex() {
        indexHotel.format(Integer.parseInt(R.TESTDATA.get("TEST_INDEX"))).click();
        return new ProductPage(getDriver());
    }

    public OrderPage clickFlightButtonByIndex() {
        flightBurtonByIndex.format(Integer.parseInt(R.TESTDATA.get("TEST_INDEX"))).click();
        return new OrderPage(getDriver());
    }

    public String getData() {
        return dataFlights.getText().substring(8, 18);
    }

    public String getTravellers() {
        return travellers.getText().replaceAll("[^1-9]", "");
    }

    public String getCheckinData() {
        return dataHotels.getText().substring(10, 21);
    }

    public String getCheckoutData() {
        return dataHotels.getText().substring(24, 35);
    }

    public String getTotalCount(){return totalCount.format(Double.parseDouble(R.TESTDATA.get("TEST_INDEX"))).getText().substring(4);}


    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}
