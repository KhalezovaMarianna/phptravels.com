package webOrangehrmlive.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MaintenancePage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--large oxd-button--ghost orangehrm-admin-access-button\"]")
    private ExtendedWebElement cancelBtn;

    public MaintenancePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return title.isElementPresent();
    }

    public PimPage clickCancelButton(){
        cancelBtn.click();
        return new PimPage(getDriver());
    }
}
