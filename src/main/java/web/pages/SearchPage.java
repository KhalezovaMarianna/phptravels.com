package web.pages;

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

    @FindBy(xpath = "//*[@id=\"fadein\"]/header/div")
    private Header header;

    @FindBy(xpath = "//*[@id=\"fadein\"]/section[11]")
    private Footer footer;

    @FindBy(xpath = "(//span[@class=\"ladda-label\"])[1]")
    private ExtendedWebElement firstHotel;

    @FindBy(xpath = "//div[@class=\"card-header\"]")
    private ExtendedWebElement searchFilterTitle;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return searchFilterTitle.isElementPresent();
    }

    public boolean isEmptySearch() {
        return titleOfEmptySearch.isElementPresent();
    }

    public ProductPage clickFirstHotelBtn() {
        firstHotel.click();
        return new ProductPage(getDriver());
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}
