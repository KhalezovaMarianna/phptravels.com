package webOrangehrmlive.pages.adminPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webOrangehrmlive.pages.AdminPage;

public class PopUpDeletePage extends AbstractPage {

    @FindBy(xpath = "//p[text()=\"Are you Sure?\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[text()=\" Yes, Delete \"]")
    private ExtendedWebElement sureDeleteBtn;

    public PopUpDeletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public AdminPage clickDeleteButton() {
        sureDeleteBtn.click();
        return new AdminPage(getDriver());
    }
}
