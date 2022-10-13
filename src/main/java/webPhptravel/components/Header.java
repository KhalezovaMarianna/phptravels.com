package webPhptravel.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webPhptravel.pages.FlightsPage;
import webPhptravel.pages.HomePage;
import webPhptravel.pages.LoginPage;
import webPhptravel.pages.ProfilePage;
import webPhptravel.utils.enums.LanguagesEnum;

import java.util.List;

public class Header extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//div[@class=\"logo\"]")
    private ExtendedWebElement titleBtn;

    @FindBy(xpath = "//a[@title='hotels']")//btn
    private ExtendedWebElement hotelsBtn;

    @FindBy(xpath = "//a[@title='flights']")
    private ExtendedWebElement flightsBtn;

    @FindBy(xpath = "//a[@title='tours']")
    private ExtendedWebElement toursBtn;

    @FindBy(xpath = "//a[@title='cars']")
    private ExtendedWebElement transfersBtn;

    @FindBy(xpath = "//a[@title='visa']")
    private ExtendedWebElement visaBtn;

    @FindBy(xpath = "//a[@title='blog']")
    private ExtendedWebElement blogBtn;

    @FindBy(xpath = "//a[@title='offers']")
    private ExtendedWebElement offersBtn;

    @FindBy(xpath = "//button[@id='languages']")
    private ExtendedWebElement language;

    @FindBy(xpath = "//a[@class=\"dropdown-item waves-effect\"]")
    private List<ExtendedWebElement> languages;


    @FindBy(xpath = "//button[@id='currency']")
    private ExtendedWebElement currency;

    @FindBy(xpath = "//i[@class='la la-bars']")
    private ExtendedWebElement burgerMenuMobile;

    @FindBy(xpath = "//*[@id=\"ACCOUNT\"]")
    private ExtendedWebElement accountBtn;

    @FindBy(xpath = "//a[text()='Customer Login']")
    private ExtendedWebElement customerLoginBtn;

    @FindBy(xpath = "//a[text()=' Logout']")
    private ExtendedWebElement logOutBtn;

    @FindBy(xpath = "//*[@id=\"fadein\"]/header/div/div/div/div/div/div[2]/div/div[2]/div[3]/div/ul/li[4]/a")
    private ExtendedWebElement myProfileBtn;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage clickTitle() {
        titleBtn.click();
        return new HomePage(getDriver());
    }

    public String getLanguage() {
        return language.getAttribute("name");
    }

    public void clickLanguageButton() {
        language.clickByJs();
    }

    public <T extends AbstractPage> T setLanguage(LanguagesEnum languagesEnum, AbstractPage abstractPage) {    //void
        languages.stream().filter(f -> f.getText().equals(languagesEnum.getLanguage())).limit(1).forEach(e -> e.click());
        return (T) abstractPage;
    }

    public LoginPage clickLogOutButton() {
        logOutBtn.click();
        return new LoginPage(getDriver());
    }

    public void openBurgerMenu() {
        burgerMenuMobile.clickIfPresent(2);
    }

    public void clickAccountDropdown() {
        accountBtn.clickByJs();
    }

    public LoginPage clickCustomLoginButton() {
        customerLoginBtn.click();
        return new LoginPage(getDriver());
    }

    public FlightsPage clickFlightsButton() {
        flightsBtn.clickByJs();
        return new FlightsPage(getDriver());
    }

    public boolean checkTitleIsPresent() {
        return titleBtn.isElementPresent() && accountBtn.isElementPresent();
    }

    public ProfilePage clickProfileButton() {
        myProfileBtn.clickByJs();
        return new ProfilePage(getDriver());
    }
}

