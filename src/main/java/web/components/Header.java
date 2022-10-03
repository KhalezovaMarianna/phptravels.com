package web.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.pages.LoginPage;
import web.utils.enums.CurrencyEnum;
import web.utils.enums.LanguagesEnum;

import java.util.List;

public class Header extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {


    @FindBy(xpath = "//a[@title='hotels']")
    private ExtendedWebElement hotels;

    @FindBy(xpath = "//a[@title='flights']")
    private ExtendedWebElement flights;

    @FindBy(xpath = "//a[@title='tours']")
    private ExtendedWebElement tours;

    @FindBy(xpath = "//a[@title='cars']")
    private ExtendedWebElement transfers;

    @FindBy(xpath = "//a[@title='visa']")
    private ExtendedWebElement visa;

    @FindBy(xpath = "//a[@title='blog']")
    private ExtendedWebElement blog;

    @FindBy(xpath = "//a[@title='offers']")
    private ExtendedWebElement offers;

    @FindBy(xpath = "//button[@id='languages']")
    private ExtendedWebElement languages;

    @FindBy(xpath = "//ul[@class=\"dropdown-menu show\"]/li/a")
    private List<ExtendedWebElement> language;

    @FindBy(xpath = "//ul[@class=\"dropdown-menu show\"]")
    private List<ExtendedWebElement> listLanguages;

    @FindBy(xpath = "//button[@id='currency']")
    private ExtendedWebElement currency;

    @FindBy(xpath = "//ul[@class='dropdown-menu show']/li/a")
    private List<ExtendedWebElement> listCurrency;

    @FindBy(xpath = "//i[@class='la la-bars']")
    private ExtendedWebElement burgerMenuMobile;

    @FindBy(xpath = "//*[@id=\"ACCOUNT\"]")
    private ExtendedWebElement accountBtn;

    @FindBy(xpath = "//*[@id=\"fadein\"]/header//div[2]//div[2]/div[3]//li[1]")
    private ExtendedWebElement customerLoginBtn;


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String checkChosenLanguage() {
        return languages.getText();
    }

    public String checkChosenCurrency() {
        return currency.getText();
    }

    public void selectCurrency(CurrencyEnum currencyEnum) {
        currency.click();
        listCurrency.stream().filter(d -> d.getElement().getText().equals(currencyEnum.getCurrency())).limit(1).forEach(k -> k.getElement().click());
    }

    public void openBurgerMenu() {
        burgerMenuMobile.clickIfPresent(2);
    }

    public void selectLanguage(LanguagesEnum languagesEnum) {
        languages.clickIfPresent();
        listLanguages.stream().filter(f->f.getText().equals(languagesEnum.getLanguage().toLowerCase())).findFirst().orElseThrow(() ->
                new IllegalStateException("Language "+ " is absent!")).click();
//        listLanguages.stream().filter(f -> f.getText().equals(languagesEnum.getLanguage())).limit(1).forEach(e -> e.click());
    }

    public void openLoginMenu() {
        burgerMenuMobile.clickIfPresent();
        accountBtn.click();
    }

    public LoginPage goToLoginPage() {
        customerLoginBtn.click();
        return new LoginPage(getDriver());
    }


}

