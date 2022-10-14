package webOrangehrmlive.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.pages.LoginPage;
import webOrangehrmlive.pages.headerPages.ChangePasswordPage;
import webOrangehrmlive.pages.headerPages.PopUpAboutPage;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-list oxd-topbar-header-hamburger\"]")
    private ExtendedWebElement hamburgerMenuBtn;

    @FindBy(xpath = "//img[@alt=\"profile picture\"]")
    private ExtendedWebElement profileLabelBtn;

    @FindBy(xpath = "//a[text()=\"general.about\"]")
    private ExtendedWebElement aboutBtn;

    @FindBy(xpath = "//a[text()=\"general.change_password\"]")
    private ExtendedWebElement changePasswordBtn;

    @FindBy(xpath = "//a[text()=\"general.logout\"]")
    private ExtendedWebElement logoutBtn;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void openHamburgerMenu() {
        hamburgerMenuBtn.click();
    }

    public void clickProfileLabelButton() {
        profileLabelBtn.click();
    }

    public LoginPage clickLogoutButton() {
        logoutBtn.click();
        return new LoginPage(getDriver());
    }

    public PopUpAboutPage clickAboutButton() {
        aboutBtn.click();
        return new PopUpAboutPage(getDriver());
    }

    public ChangePasswordPage clickChangePasswordButton() {
        changePasswordBtn.click();
        return new ChangePasswordPage(getDriver());
    }
}
