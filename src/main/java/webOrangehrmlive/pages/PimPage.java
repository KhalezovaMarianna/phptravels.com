package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.HamburgerMenu;
import webOrangehrmlive.components.HeaderMenu;
import webOrangehrmlive.pages.pimPages.*;

public class PimPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"oxd-topbar-header\"]")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//div[@class=\"oxd-sidepanel-body\"]")
    private HamburgerMenu hamburgerMenu;

    @FindBy(xpath = "//div[@class=\"oxd-table-filter\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//a[text()=\"%s\"]")
    private ExtendedWebElement configurationAnyBtn;

    @FindBy(xpath = "//li[@class=\"oxd-topbar-body-nav-tab --parent\"]")
    private ExtendedWebElement configurationBtn;
    public PimPage(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public HamburgerMenu getHamburgerMenu() {
        return hamburgerMenu;
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }
    public void clickPimButtons(String button){
        configurationBtn.clickIfPresent();
        configurationAnyBtn.format(button).click();
    }
}
