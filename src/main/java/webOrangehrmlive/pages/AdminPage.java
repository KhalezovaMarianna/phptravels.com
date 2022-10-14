package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.components.HeaderMenu;

public class AdminPage extends AbstractPage {

    @FindBy(xpath = "")
    private HeaderMenu headerMenu;
    @FindBy(xpath = "//div[@class=\"oxd-table-filter\"]")
    private ExtendedWebElement systemsUsersFilter;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return systemsUsersFilter.isElementPresent();
    }


}
