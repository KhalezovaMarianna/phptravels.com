package web.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.components.Footer;
import web.components.Header;

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
    private ExtendedWebElement flightFromForm;

    @FindBy(xpath = "//input[@placeholder =\"To Destination\"]")
    private ExtendedWebElement destinationForm;

    @FindBy(xpath = "//button[@id =\"flights-search\"]")
    private ExtendedWebElement flightSearchBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public void typeFlightFromForm(String city){
        flightFromForm.type(city);
    }

    public void typeDestinationForm(String city){
        destinationForm.type(city);
    }

    public SearchPage clickFlightSearchButton(){
        flightSearchBtn.click();
        return new SearchPage(getDriver());
    }
    public void clickHomeButtons(String homeButtonsEnum) {
        homeBtn.format(homeButtonsEnum).click();
    }

    public boolean checkWorkingOfHomeButtons(String homeButtonsEnum) {
        if (checkingHomeBtn.format(homeButtonsEnum).isElementPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}
